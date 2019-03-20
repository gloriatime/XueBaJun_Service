package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.CourseMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.ProfessorMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Professor;
import com.xuebajun.service.ScoreService;

@Service
public class ScoreServiceImp implements ScoreService {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	@Override
	public Book scoreBook(Book book) {
		// TODO Auto-generated method stub
		bookMapper.score(book);
		return bookMapper.getById(book);
	}

	@Override
	public Document scoreDocument(Document d) {
		documentMapper.score(d);
		return documentMapper.getById(d);
	}

	@Override
	public Professor scoreProfessor(Professor p) {
		// TODO Auto-generated method stub
		professorMapper.score(p);
		return professorMapper.getById(p);
	}

	@Override
	public Course scoreCourse(Course c) {
		// TODO Auto-generated method stub
		courseMapper.score(c);
		return courseMapper.getById(c);
	}

}
