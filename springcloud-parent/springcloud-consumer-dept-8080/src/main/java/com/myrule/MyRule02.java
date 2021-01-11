package com.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
/**
 * 设置负载均衡的算法
 * @author 起来
 *
 */
@Configuration
public class MyRule02 {

	@Bean
	public IRule Ruleplus(){
		
		return new NewRule();
	}
	
}
