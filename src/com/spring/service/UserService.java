package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.UserDao;
import com.spring.pojo.User;

@Service
public class UserService implements UserServiceInterface {

	 
	@Autowired
	private UserDao userDao;
	public void addUser(User user) {
		//通过DAO访问数据库
		System.out.println("service");
		userDao.addUser(user);
	}
	public void findUser(String user) {
		userDao.findUser(user);
	}

}
