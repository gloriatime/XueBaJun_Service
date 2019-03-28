package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.CollectBook;
import com.xuebajun.pojo.CollectCourse;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.User;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CollectService;
import com.xuebajun.service.CourseService;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.NewsService;
import com.xuebajun.service.UserService;

@Controller
@RequestMapping("")
public class CollectController {
	@Autowired
	UserService userService;
	@Autowired
	CollectService collectService;
	@Autowired
	BookService bookService;
	@Autowired
    CourseService courseService;
	@Autowired
    DocumentService documentService;
	@Autowired
    NewsService newsService;
	
	@RequestMapping("/GetMyCollectedDocuments")
	public @ResponseBody User getMyCollectedDocuments(@RequestBody User user){
		return userService.getCollectedDocuments(user);
	}
	
	@RequestMapping("/GetMyCollectedBooks")
	public @ResponseBody User getMyCollectedBooks(@RequestBody User user){
		return userService.getCollectedBooks(user);
	}
	
	@RequestMapping("/GetMyCollectedCourses")
	public @ResponseBody User getMyCollectedCourses(@RequestBody User user){
		return userService.getCollectedCourses(user);
	}
	
	@RequestMapping("/DeleteCollectedDocument")
	public void deleteCollectedDocument(@RequestBody CollectDocument c) {
		collectService.deleteCollecedDocument(c);
	}
	
	// 收藏时给关注自己的人发送消息
	@RequestMapping("/CollectDocument")
	public void collectDocument(@RequestBody CollectDocument c) {
		collectService.collectDocument(c);
		User u = c.getUser();
		// 收藏为收藏人增加标签关联程度
		c.getDocument().setApplicant(u.getPhone());
		Document d = documentService.selectById(c.getDocument());
		u = userService.getByPhone(u);
		User temp = userService.getConcernMeList(u);
		News n = new News();
		for(Concern concern:temp.getConcern_me_list()) {
			n.setBelong(concern.getUser());
			n.setContent("(｡･∀･)ﾉﾞ嗨~我是 "+u.getName()+" ,我刚刚收藏了资料 "+d.getName()+" ,你也来看看吧。");
			newsService.add(n);
		}		
	}
	
	@RequestMapping("/DeleteCollectedBook")
	public void deleteCollectedBook(@RequestBody CollectBook c) {
		collectService.deleteCollecedBook(c);
	}
	
	@RequestMapping("/CollectBook")
	public void collectBook(@RequestBody CollectBook c) {
		collectService.collectBook(c);
		User u = c.getUser();
		Book b = bookService.getById(c.getBook());
		u = userService.getByPhone(u);
		User temp = userService.getConcernMeList(u);
		News n = new News();
		for(Concern concern:temp.getConcern_me_list()) {
			n.setBelong(concern.getUser());
			n.setContent("(｡･∀･)ﾉﾞ嗨~我是 "+u.getName()+" ,我刚刚收藏了书籍 "+b.getName()+" ,你也来看看吧。");
			newsService.add(n);
		}	
	}
	
	@RequestMapping("/DeleteCollectedCourse")
	public void deleteCollectedCourse(@RequestBody CollectCourse c) {
		collectService.deleteCollecedCourse(c);
	}
	
	@RequestMapping("/CollectCourse")
	public void collectCourse(@RequestBody CollectCourse c) {
		collectService.collectCourse(c);
		User u = c.getUser();
		Course course = courseService.getById(c.getCourse());
		u = userService.getByPhone(u);
		User temp = userService.getConcernMeList(u);
		News n = new News();
		for(Concern concern:temp.getConcern_me_list()) {
			n.setBelong(concern.getUser());
			n.setContent("(｡･∀･)ﾉﾞ嗨~我是 "+u.getName()+" ,我刚刚收藏了课程 "+course.getName()+" ,你也来看看吧。");
			newsService.add(n);
		}	
	}
}
