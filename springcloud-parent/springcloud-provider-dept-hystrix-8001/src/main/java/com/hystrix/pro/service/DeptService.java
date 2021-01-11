package com.hystrix.pro.service;

import java.util.List;

import com.springcloud.entity.Dept;

public interface DeptService {
	
	//增加
	public boolean addDept(Dept dept);
	
	//用ID查询
	public Dept findById(Long deptno);
	List<Dept> selcetinfo();
}
