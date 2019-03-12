package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Document;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CommentService;


@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	CommentService commentService;
	
	@Override
	public void add(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book getById(Book book) {
		
		book = bookMapper.getById(book);
		Book temp = new Book();
		temp = bookMapper.getMyCommentList(book);
		
		book.setCommentList(temp.getCommentList());
			
		return book;
	}

}
