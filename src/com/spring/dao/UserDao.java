package com.spring.dao;

import com.spring.pojo.User;

public interface UserDao {

	public void addUser(User user);
	
	public void findUser(String user);
}
