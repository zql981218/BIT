package com.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
/**
 * 自定义的算法
 * @author 起来
 *
 */
public class NewRule extends AbstractLoadBalancerRule{

	//访问的总次数
	private int total=0;
	//当前的访问所以
	private int currentIndex=0;
	
	//在源码的基础上，将访问次数修改为5词
	public Server choose(ILoadBalancer lb,Object key) {
		//如果当前没有负载访问量，则返回空值
		if(lb == null){
			return null;
		}
		Server server = null;
		//判断当前的访问次数是否达到五次
		while(server == null){
			if(Thread.interrupted()){
				return null;
			}
			//拿到当前访问正常的服务列表，存放到集合中
			List<Server> upList = lb.getReachableServers();
			//拿到所有服务
			List<Server> allList = lb.getAllServers();
			//拿到所有服务的数量
			int serverCount = allList.size();
			if(serverCount == 0){
				return null;
			}
			if(total<5){
				//拿到当前服务下标(索引)
				server = upList.get(currentIndex);
				total++;
			}else{
				total = 0;
				currentIndex++;
				if(currentIndex>=upList.size()){
					currentIndex=0;
				}
			}
			if(server == null){
				Thread.yield();
				continue;
			}
			if(server.isAlive()){
				return (server);
			}
			server = null;
			Thread.yield();
		}
		
		return server;
	}
	
	@Override
	public Server choose(Object key) {
		//将自定义的方法，当做最终服务的返回值，修改完毕后，按照此服务返回即可
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		
	}

}
