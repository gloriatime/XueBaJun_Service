package com.xuebajun.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.Tag;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CourseService;
import com.xuebajun.service.ProfessorService;
import com.xuebajun.service.TagService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private BookService bookService;
	@Autowired
    ProfessorService professorService;
	
	@Test (timeout = 1000)
	public void testGetCourseById() {
		Course course = new Course();
		course.setId(3);
		course = courseService.getById(course);
		System.out.println("课程信息：");
		System.out.println("返回课程信息："+course.getName());
		System.out.println("相关书籍信息："+course.getBook().getName());
		System.out.println("相关教师信息："+course.getProfessorCourseList().get(0).getProfessor().getName());
	}
	
	@Test (timeout = 1000)
	public void testGetBookById() {
		Book book = new Book();
		book.setId(3);
		book = bookService.getById(book);
		System.out.println("书籍信息：");
		System.out.println("返回书籍信息："+book.getName());
		System.out.println("相关课程信息："+book.getCourse().getName());
	}
	
	@Test (timeout = 1000)
	public void testGetProfessorById() {
		Professor p = new Professor();
		p.setId(2);
		p = professorService.getById(p);
		System.out.println("教师信息：");
		System.out.println("返回教师信息："+p.getIntro());
		System.out.println("相关课程信息："+p.getProfessorCourseList().get(0).getCourse().getName());
		System.out.println("相关评论信息："+p.getCommentList().get(0).getContent());
	}

}
