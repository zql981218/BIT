package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;



@Data
//@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)	//可以用方法链对属性赋值的注解
public class Dept {

    private Long deptno;        
    private String dname;       
    private String db_source;   

    public static void main(String[] args) {
        Dept dept = new Dept();

    }


}
