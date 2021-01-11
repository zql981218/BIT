package com.spingcloud.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spingcloud.pro.service.DeptService;
import com.springcloud.entity.Dept;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	//Springcloud对于获取当前微服务的信息这种功能，专门封装一个api，叫"DiscoveryClient"
	@Autowired
	private DiscoveryClient client;
	
	/**
	 * 增加
	 * 在通过地址栏给数据库增加数据时，
	 * 当控制器中的方法参数为对象时，需要在该对象前方加上一个注解，
	 * 将对象的格式转化为json格式注解。
	 * @param dept
	 * @return
	 */
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean addInfo(@RequestBody Dept dept){
		return deptService.addDept(dept);
	}
	
	//用ID查询
		@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
		public Dept showById(@PathVariable("id") Long id){
			Dept dept = deptService.findById(id);
			return dept;
		}
	
	@RequestMapping("showAll")
	public List<Dept> showAll(){
		List<Dept> list = deptService.selcetinfo();
		System.out.println(list);
		return list;
	}
	//打印当前微服务的信息
	@RequestMapping(value="/discovery/dept",method=RequestMethod.GET)
	public Object discovery(){
		//拿到访问当前微服务信息(IP、端口号)
		List<String> list = client.getServices();
		System.out.println("****以下是client.getServices()返回值的信息***");
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("****************************");
		System.out.println("client.getLocalServiceInstance().getClass():"+client.getLocalServiceInstance().getClass());
		List<ServiceInstance> instList = client.getInstances("zbwspringcloud-dept");
		for (ServiceInstance si : instList) {
			System.out.println("si.getServiceId():"+si.getServiceId());
			System.out.println("si.getHost():"+si.getHost());
			System.out.println("si.getPort():"+si.getPort());
			System.out.println("si.getMetadata():"+si.getMetadata());
			System.out.println("si.getUri():"+si.getUri());
		}
		return client;
	}
}
