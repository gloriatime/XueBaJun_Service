package com.xuebajun.service;

import java.util.List;

import com.xuebajun.pojo.User;

public interface UserService {
	public boolean addUser(User user);
	public User checkUser(User user);
	public User checkIn(User user);
	
	// 账号管理更改信息功能
	public User changeName(User user);
	public User changeGrade(User user);
	public User changeCollege(User user);
	public User changePwd(User user);
	public User changeInterest(User user);
	
	// 账号管理“我的关注”功能
	// 得到关注列表
	public User getMyConcernList(User user);
	public User getConcernMeList(User user);
	
	// 账号管理“我的收藏”功能
	// 得到收藏列表
	public User getCollectedDocuments(User user);	
	public User getCollectedBooks(User user);	
	public User getCollectedCourses(User user);
}
