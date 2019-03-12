package com.xuebajun.service;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.News;

public interface BookService {
	public void add(Book book);
	public void delete(Book book);
	public Book getById(Book book);
}
