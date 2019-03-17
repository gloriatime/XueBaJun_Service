package com.xuebajun.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Tag;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CourseService;
import com.xuebajun.service.TagService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private BookService bookService;
	
	@Test (timeout = 1000)
	public void testGetCourseById() {
		Course course = new Course();
		course.setId(3);
		course = courseService.getById(course);
		System.out.println("�γ���Ϣ��");
		System.out.println("���ؿγ���Ϣ��"+course.getName());
		System.out.println("����鼮��Ϣ��"+course.getBook().getName());
	}
	
	@Test (timeout = 1000)
	public void testGetBookById() {
		Book book = new Book();
		book.setId(3);
		book = bookService.getById(book);
		System.out.println("�鼮��Ϣ��");
		System.out.println("�����鼮��Ϣ��"+book.getName());
		System.out.println("��ؿγ���Ϣ��"+book.getCourse().getName());
	}

}
