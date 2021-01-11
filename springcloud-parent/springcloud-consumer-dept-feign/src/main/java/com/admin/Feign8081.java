package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/* 若springcloud-api中的DeptClientService接口所在的的路径与springcloud-consumer-dept-feign中的启动类所在包的路径不同
 * 则可以使用 注解方式扫描接口所在包和Controller层所在包（二者缺一不可）
 *@SpringBootApplication(scanBasePackages={"com.springcloud.service","com.admin.controller"})
 */
@SpringBootApplication(scanBasePackages={"com.springcloud.service","com.admin.controller"})
@EnableEurekaClient
@EnableFeignClients(basePackages={"com.springcloud"})		//开启用Feign实现负载均衡的模式	
public class Feign8081 {

	public static void main(String[] args) {
		SpringApplication.run(Feign8081.class, args);
	}

}
