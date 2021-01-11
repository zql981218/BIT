package com.hystrix.pro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hystrix.pro.dao.DeptDao;
import com.hystrix.pro.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.entity.Dept;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao deptDao;
	
	@Override
	public List<Dept> selcetinfo() {
		List<Dept> list = deptDao.selectAll();
		return list;
	}

	@Override
	public boolean addDept(Dept dept) {
		// TODO Auto-generated method stub
		return deptDao.add(dept);
		
	}

	@Override
	public Dept findById(Long deptno) {
		// TODO Auto-generated method stub
		return deptDao.selectById(deptno);
	}
	
	
}
