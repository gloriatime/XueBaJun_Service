package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;

public interface BookMapper {
	public void add(Book book);
	public void delete(Book book);
	public Book getById(Book book);
	public List<Book> searchBookList(Book book);
}
