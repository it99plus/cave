package com.it99plus.model;

import org.springframework.stereotype.Component;

@Component
public class Staff {
	private int id;
	private String name;
	
	public Staff() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Staff(int id, String name) {
		setId( id);
		setName(name) ;
	}
	
	
	
}
