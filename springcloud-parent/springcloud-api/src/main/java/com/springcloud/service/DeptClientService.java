package com.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.entity.Dept;

@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory=GetFeiginByHystrix.class)
public interface DeptClientService {

	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean addDept(@RequestBody Dept dept);

	// 用ID查询
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	public Dept findById(@PathVariable("id") Long deptno);

	// 查询
	@RequestMapping("showAll")
	List<Dept> findAll();
}
