package com.xuebajun.service;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;

public interface SearchService {
	public Course searchCourse(Course course);
	public Document searchDocument(Document doument);
	public Book searchBook(Book book);
}
