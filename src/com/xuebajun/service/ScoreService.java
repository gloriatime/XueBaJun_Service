package com.xuebajun.service;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Professor;

public interface ScoreService {
	public Book scoreBook(Book book);
	public Document scoreDocument(Document d);
	public Professor scoreProfessor(Professor p);
	public Course scoreCourse(Course c);
}
