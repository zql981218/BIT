package com.admin.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {

	//属性,用软编码的方式获取github上yml中的相关key的信息
	@Value("${spring.application.name}")
	private String applicationName;

	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers;

	@Value("${server.port}")
	private String port;
	
	//方法 ，用请求映射方法显示出，key（键）对应的值(value)
	@RequestMapping("/config")
	public String getConfig()
	{
		String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
		//将信息打印控制台
		System.out.println("******str: " + str);
		//将信息显示浏览器页面
		return "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
	}
	
}
