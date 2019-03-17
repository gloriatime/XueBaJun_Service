package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CourseService;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.NewsService;
import com.xuebajun.service.ProfessorService;
import com.xuebajun.service.RecommendService;
import com.xuebajun.service.TagService;

@Controller
@RequestMapping("")
// 展示系统--用来展示资料、书籍、课程、用户、教师等信息
public class ShowInfoController {
	
	@Autowired
	BookService bookService;
	@Autowired
    CourseService courseService;
	@Autowired
    DocumentService documentService;
	@Autowired
    ProfessorService professorService;
	
	@RequestMapping("/GetDocument")
    public @ResponseBody Document getDocument(@RequestBody Document document) {
       return documentService.selectById(document);
    }
	
	@RequestMapping("/GetCourse")
    public @ResponseBody Course getCourse(@RequestBody Course course) {
       return courseService.getById(course);
    }
	
	@RequestMapping("/GetBook")
    public @ResponseBody Book getBook(@RequestBody Book book) {
       return bookService.getById(book);
    }
	
	@RequestMapping("/GetProfessor")
    public @ResponseBody Professor getProfessor(@RequestBody Professor professor) {
       return professorService.getById(professor);
    }

}
