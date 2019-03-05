package com.xuebajun.mapper;

import com.xuebajun.pojo.Book;

public interface BookMapper {
	public void add(Book book);
	public void delete(Book book);
	public Book getById(Book book);
}
