package com.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer	//说明此模块是Eureka的服务端
public class EurekaServer7002 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7002.class, args);
	}
}
