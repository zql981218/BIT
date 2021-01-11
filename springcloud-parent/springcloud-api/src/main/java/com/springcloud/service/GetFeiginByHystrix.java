package com.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.springcloud.entity.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class GetFeiginByHystrix implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable arg0) {
		
		return new DeptClientService() {
			
			@Override
			public Dept findById(Long deptno) {
				return new Dept().setDeptno(deptno).setDname("该ID:"+deptno+"在数据中不存在，").setDb_source("没有对应的数据库！(当出现该信息时，说明已经出现“服务降级”的现象(关闭了一个服务))");
			}
			
			@Override
			public List<Dept> findAll() {
				return null;
			}
			
			@Override
			public boolean addDept(Dept dept) {
				return false;
			}

		
		};
	}

}
