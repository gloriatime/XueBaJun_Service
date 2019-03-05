package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.CourseMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.UserMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.User;
import com.xuebajun.service.AboutMeService;

@Service
public class AboutMeServiceImp implements AboutMeService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	BookMapper bookMapper;
	@Autowired
	CourseMapper courseMapper;
	@Override
	public User getMyDocument(User user) {
		// TODO Auto-generated method stub
		return userMapper.getMydocumentList(user);
	}

	@Override
	public User getMyComment(User user) {
		// TODO Auto-generated method stub
		user = userMapper.getMyCommentList(user);
		List<Comment> myComment = user.getMyComment();
		for(Comment c:myComment) {
			if(c.getType().compareTo("¡®document¡¯")==0) {
				Document document = new Document();
				document.setId(c.getBelong());
				document = documentMapper.getById(document);
				c.setDocument(document);
			}else if(c.getType().compareTo("¡®book¡¯")==0) {
				Book book = new Book();
				book.setId(c.getBelong());
				book = bookMapper.getById(book);
				c.setBook(book);
			}else if(c.getType().compareTo("¡®course¡¯")==0) {
				Course course = new Course();
				course.setId(c.getBelong());
				course = courseMapper.getById(course);
				c.setCourse(course);
			}
		}
		user.setMyComment(myComment);
		return user;
	}

	@Override
	public User getMyNews(User user) {
		// TODO Auto-generated method stub
		return userMapper.getMyNewsList(user);
	}

}
