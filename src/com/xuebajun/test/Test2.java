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
		System.out.println("�γ���Ϣ��");
		System.out.println("���ؿγ���Ϣ��"+course.getName());
		System.out.println("����鼮��Ϣ��"+course.getBook().getName());
		System.out.println("��ؽ�ʦ��Ϣ��"+course.getProfessorCourseList().get(0).getProfessor().getName());
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
	
	@Test (timeout = 1000)
	public void testGetProfessorById() {
		Professor p = new Professor();
		p.setId(2);
		p = professorService.getById(p);
		System.out.println("��ʦ��Ϣ��");
		System.out.println("���ؽ�ʦ��Ϣ��"+p.getIntro());
		System.out.println("��ؿγ���Ϣ��"+p.getProfessorCourseList().get(0).getCourse().getName());
		System.out.println("���������Ϣ��"+p.getCommentList().get(0).getContent());
	}

}
