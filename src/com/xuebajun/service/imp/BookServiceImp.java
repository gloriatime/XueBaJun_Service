package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.UserTagMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CommentService;


@Service
public class BookServiceImp implements BookService {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	CommentService commentService;
	@Autowired
	UserTagMapper userTagMapper;
	
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
		String applicant = book.getApplicant();
		
		book = bookMapper.getById(book);
		Book temp = new Book();
		
		temp = bookMapper.getMyCommentList(book);
		book.setCommentList(temp.getCommentList());
		
		temp = bookMapper.getTagList(book);
		book.setTagList(temp.getTagList());
		
		Course c  = new Course();
		c = bookMapper.getRelatedCourse(book);
		book.setCourse(c);
		
			
		// 为用户增加tag浏览次数
		for(Tag t:book.getTagList()) {
			UserTag ut = new UserTag();
			ut.setUser(applicant);
			ut.setTag(t.getId());
			if(userTagMapper.getUserTag(ut)!=null) {
				userTagMapper.pulsOnetoTimes(ut);
			}else {
				ut.setTimes(1);
				userTagMapper.add(ut);
			}
			
		}
		
		return book;
	}

}
