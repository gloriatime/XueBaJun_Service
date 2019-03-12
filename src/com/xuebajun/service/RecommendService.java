package com.xuebajun.service;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;

public interface RecommendService {
	// ��ҳ��ʾ���Ƽ���--����ֵֻ��ʹ�����е�List�ṹ����
	public UserTag getRecommendList(User user);
	
	// ��ҳ��ʾ���Ƽ���--���Ӹ��Ի�
	public Document getRecommendDocumentList(User user);
	public Course getRecommendCourseList(User user);
	public Book getRecommendBookList(User user);
	
}
