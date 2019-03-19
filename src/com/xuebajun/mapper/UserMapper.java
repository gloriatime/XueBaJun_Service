package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.User;

public interface UserMapper {
	
	public int add(User user);
	
	public User getByPhone(User user);
	
	public void changePoint(User user);
	
	public void changeName(User user);
	
	public void changeCollege(User user);
	
	public void changeGrade(User user);
	
	public void changeInterest(User user);
	
	public void changePwd(User user);
	
	public User getMyConcernList(User user);
	
	public User getConcernMeList(User user);
	
	public User getMyCollectedDocumentsList(User user);
	
	public User getMyCollectedBooksList(User user);
	
	public User getMyCollectedCoursesList(User user);
	
	public User getMydocumentList(User user);
	public User getMyCommentList(User user);
	public User getMyNewsList(User user);
}
