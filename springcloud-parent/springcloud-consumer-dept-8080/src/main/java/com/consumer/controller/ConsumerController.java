package com.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springcloud.entity.Dept;

@RestController
public class ConsumerController {
	
	//定义一个常量，用于存放相同访问路径
//	private static final String REST_URL_PREFIX = "http://127.0.0.1:8001";
	private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-DEPT";
	//此处需要一个对象，用来提供增删改查方法
	@Autowired
	private RestTemplate resttemplate;
	
	
	@RequestMapping("/consumer/dept/add")
	public boolean addInfoConsumer(Dept dept){
		
		return resttemplate.postForObject(REST_URL_PREFIX +"/dept/add", dept, Boolean.class);
	}
	//删除
	
	//修改
	
	//查询
	@RequestMapping("/consumer/dept/showAll")
	public List<Dept> showAll(){
		return resttemplate.getForObject(REST_URL_PREFIX + "/showAll", List.class);
		}
	
	//用Id查询
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept showById(@PathVariable("id") Long id){
		return resttemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	//打印当前微服务的信息
	@RequestMapping(value="/consumer/discovery/dept")
	public Object discovery(){
		return resttemplate.getForObject(REST_URL_PREFIX+"/discovery/dept", Object.class);
	}
	
}
