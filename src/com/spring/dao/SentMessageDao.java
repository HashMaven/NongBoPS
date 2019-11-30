package com.spring.dao;


import java.util.List;

import com.spring.pojo.SentMessage;

public interface SentMessageDao {
	public void findAllSentMessage();
	public List<SentMessage> findAllSentMessageByDate();
}
