package com.xuebajun.service;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;

public interface RecommendService {
	// 主页显示的推荐表单--返回值只是使用其中的List结构而已
	public UserTag getRecommendList(User user);
	
	// 分页显示的推荐表单--更加个性化
	public Document getRecommendDocumentList(User user);
	public Course getRecommendCourseList(User user);
	public Book getRecommendBookList(User user);
	
}
