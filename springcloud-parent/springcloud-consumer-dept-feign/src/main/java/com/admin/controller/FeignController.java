package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entity.Dept;
import com.springcloud.service.DeptClientService;

@RestController
public class FeignController {

	//拿到api项目中的接口对象
	@Autowired
	private DeptClientService deptClientService;
	
	@RequestMapping(value="/consumer/dept/add")
	public boolean addInfo(@RequestBody Dept dept){
		return deptClientService.addDept(dept);
	}
	
	@RequestMapping(value="/consumer/dept/get/{id}",method=RequestMethod.GET)
	public Dept showById(@PathVariable("id") Long id){
		Dept dept = deptClientService.findById(id);
		return dept;
	}
	
	@RequestMapping("showAll")
	public List<Dept> showAll(){
		List<Dept> list = deptClientService.findAll();
		return list;
	}
	
}
