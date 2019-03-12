package com.xuebajun.service;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;

public interface TopService {
	public Document getTopDocument();
	public Course getTopCourse();
	public Book getTopBook();
	public Course getTopTwentyCourse();
	public Book getTopTwentyBook();
}
