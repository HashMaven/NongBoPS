package com.spring.pojo;

import java.io.Serializable;
import java.util.Date;

public class SentMessage implements Serializable {

	private String ShopName;
	private int SentNum;
	private int ReturnNum;
	private int SentNo;
	private Date SentDate;
	private String User;
	private String GoodsName;
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public int getSentNum() {
		return SentNum;
	}
	public void setSentNum(int sentNum) {
		SentNum = sentNum;
	}
	public int getReturnNum() {
		return ReturnNum;
	}
	public void setReturnNum(int returnNum) {
		ReturnNum = returnNum;
	}
	public int getSentNo() {
		return SentNo;
	}
	public void setSentNo(int sentNo) {
		SentNo = sentNo;
	}
	public Date getSentDate() {
		return SentDate;
	}
	public void setSentDate(Date sentDate) {
		SentDate = sentDate;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getGoodsName() {
		return GoodsName;
	}
	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}
	public SentMessage(String shopName, int sentNum, int returnNum, int sentNo, Date sentDate, String user,
			String goodsName) {
		super();
		ShopName = shopName;
		SentNum = sentNum;
		ReturnNum = returnNum;
		SentNo = sentNo;
		SentDate = sentDate;
		User = user;
		GoodsName = goodsName;
	}
	@Override
	public String toString() {
		return "SentMessage [ShopName=" + ShopName + ", SentNum=" + SentNum + ", Return=" + ReturnNum + ", SentNo="
				+ SentNo + ", SentDate=" + SentDate + ", User=" + User + ", GoodsName=" + GoodsName + "]";
	}
	
}
