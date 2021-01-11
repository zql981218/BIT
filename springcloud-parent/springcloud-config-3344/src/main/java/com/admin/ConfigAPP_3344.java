package com.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer		//开启用“config”管理配置文件的功能
public class ConfigAPP_3344 {

	public static void main(String[] args) {
		SpringApplication.run(ConfigAPP_3344.class, args);
	}

}
