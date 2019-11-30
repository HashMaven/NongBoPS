package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.SentMessageDao;
import com.spring.dao.UserDao;
import com.spring.pojo.SentMessage;
import com.spring.pojo.User;

@Service
public class UserService implements UserServiceInterface {

	 
	@Autowired
	private UserDao userDao;
	@Autowired
	private SentMessageDao sentMessageDao;
	public void addUser(User user) {
		//通过DAO访问数据库
		System.out.println("service");
		userDao.addUser(user);
	}
	public void findUser(String user) {
		userDao.findUser(user);
	}
	@Override
	public List<SentMessage> findAllSentMessageByDate() {
		System.out.println("a:"+sentMessageDao.findAllSentMessageByDate().toString());
		return sentMessageDao.findAllSentMessageByDate();
	}
	

}
