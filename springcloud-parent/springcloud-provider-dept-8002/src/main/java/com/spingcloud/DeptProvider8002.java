package com.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient	//开启Eureka客户端增加(注册)功能
@EnableDiscoveryClient	//开启“发现”(查看)当前服务功能
public class DeptProvider8002 {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8002.class, args);
	}
}
