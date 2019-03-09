package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.CollectBook;
import com.xuebajun.pojo.CollectCourse;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.User;
import com.xuebajun.service.CollectService;
import com.xuebajun.service.UserService;

@Controller
@RequestMapping("")
public class CollectController {
	@Autowired
	UserService userService;
	@Autowired
	CollectService collectService;
	
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
	
	@RequestMapping("/CollectDocument")
	public void collectDocument(@RequestBody CollectDocument c) {
		collectService.collectDocument(c);
		
	}
	
	@RequestMapping("/DeleteCollectedBook")
	public void deleteCollectedBook(@RequestBody CollectBook c) {
		collectService.deleteCollecedBook(c);
	}
	
	@RequestMapping("/CollectBook")
	public void collectBook(@RequestBody CollectBook c) {
		collectService.collectBook(c);
	}
	
	@RequestMapping("/DeleteCollectedCourse")
	public void deleteCollectedCourse(@RequestBody CollectCourse c) {
		collectService.deleteCollecedCourse(c);
	}
	
	@RequestMapping("/CollectCourse")
	public void collectCourse(@RequestBody CollectCourse c) {
		collectService.collectCourse(c);
	}
}
