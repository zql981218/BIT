package com.consumer.cfgBean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

/**
 * application.xml <bean class="" id/>
 * @author Administrator
 *
 */

@Configuration
public class ConfigBean {
	
	/**
	 * RestTemplate
	 * 属于一个工具类，该工具类中封装一些对数据库进行增删改查的方法，
	 * 我们只需要调用即可。
	 * @return
	 */
	@Bean
	@LoadBalanced //负载均衡
	public RestTemplate getTemplate(){
		
		return new RestTemplate();
	}
	
	//修改用负载均衡方式访问数据库的顺序
	@Bean
	public IRule myRule(){
			
		//轮询算法(按照顺序依次访问)
		return new RoundRobinRule();
		//随机算法(随机访问)
//		return new RandomRule();
	}
	
}
