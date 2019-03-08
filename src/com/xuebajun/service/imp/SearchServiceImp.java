package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.CourseMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.service.SearchService;

@Service
public class SearchServiceImp implements SearchService {

	@Autowired
	CourseMapper courseMapper;
	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public Course searchCourse(Course course) {
		// TODO Auto-generated method stub
		course.setCourseList(courseMapper.searchCourseList(course));
		return course;
	}

	@Override
	public Document searchDocument(Document document) {
		// TODO Auto-generated method stub
		document.setDocumentList(documentMapper.searchDocumentList(document));
		return document;
	}

	@Override
	public Book searchBook(Book book) {
		// TODO Auto-generated method stub
		book.setBookList(bookMapper.searchBookList(book));
		return null;
	}

}
