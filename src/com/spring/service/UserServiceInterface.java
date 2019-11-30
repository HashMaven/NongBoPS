package com.spring.service;

import java.util.List;

import com.spring.pojo.SentMessage;
import com.spring.pojo.User;

public interface UserServiceInterface {
	
	public void addUser(User user);
	
	public void findUser(String user);
	
	public List<SentMessage> findAllSentMessageByDate();
}
