package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.TopDate;

public interface BookMapper {
	public void add(Book book);
	public void delete(Book book);
	public Book getById(Book book);
	
	public Book getMyCommentList(Book book);
	
	public List<Book> searchBookList(Book book);
	
	public Book getTopOne(TopDate topDate);
	public Book getLastOne();
	public List<Book> getTopTwenty(TopDate topDate);
	
}
