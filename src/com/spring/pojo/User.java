package com.spring.pojo;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

public class User implements Serializable {

	private int id;
	@Pattern(regexp="\\w{3,8}",message="y用户名必须在3-8位之间")
	private String name;
	@Pattern(regexp="\\w{6,12}",message="密码必须在6-12位之间")
	private String password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User() {
		super();
		 
	}
	 
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	
}
