package com.spingcloud.pro.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.springcloud.entity.Dept;

@Repository
@Mapper
public interface DeptDao {
	
	//查询
	List<Dept> selectAll();
	//用ID进行查询
	public Dept selectById(Long deptno);
	
	//增加
	public boolean add(Dept dept);
	
}
