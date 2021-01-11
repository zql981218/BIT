package com.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication
@EnableEurekaClient	//开启Eureka客户端增加(注册)功能
@EnableDiscoveryClient	//开启“发现”(查看)当前服务功能
@EnableHystrix //开启Hystrix
public class HystrixProvider8001 {
	public static void main(String[] args) {
		SpringApplication.run(HystrixProvider8001.class, args);
	}
	
	
	


}
