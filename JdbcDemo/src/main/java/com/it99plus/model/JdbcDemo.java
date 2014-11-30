		package com.it99plus.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it99plus.dao.JdbcDaoImpl;

public class JdbcDemo {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl",JdbcDaoImpl.class );
		
		
		System.out.println(dao.getStaffName(2));
		
//		Staff staff = dao.getStaff(2);
//		System.out.println("Staff id: " + staff.getId() + " " + staff.getName());
//		
//		Staff staff = new JdbcDaoImpl().getStaff(2);
//		System.out.println(staff.getId() + " : " + staff.getName());
		 
	}
}
