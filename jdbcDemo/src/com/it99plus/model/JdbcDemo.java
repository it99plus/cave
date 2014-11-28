package com.it99plus.model;

import com.it99plus.dao.JdbcDaoImpl;

public class JdbcDemo {
	public static void main(String[] args) {
		
		Staff circle = new JdbcDaoImpl().getStaff(2);
		
		System.out.println(circle.getId() + " : " + circle.getName());
		 
	}
}
