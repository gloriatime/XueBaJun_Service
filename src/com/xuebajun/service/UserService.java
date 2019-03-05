package com.xuebajun.service;

import java.util.List;

import com.xuebajun.pojo.User;

public interface UserService {
	public boolean addUser(User user);
	public User checkUser(User user);
	public User checkIn(User user);
	
	// �˺Ź��������Ϣ����
	public User changeName(User user);
	public User changeGrade(User user);
	public User changeCollege(User user);
	public User changePwd(User user);
	public User changeInterest(User user);
	
	// �˺Ź����ҵĹ�ע������
	// �õ���ע�б�
	public User getMyConcernList(User user);
	public User getConcernMeList(User user);
	
	// �˺Ź����ҵ��ղء�����
	// �õ��ղ��б�
	public User getCollectedDocuments(User user);	
	public User getCollectedBooks(User user);	
	public User getCollectedCourses(User user);
}
