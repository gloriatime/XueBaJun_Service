package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.User;
import com.xuebajun.service.TopService;

@Controller
@RequestMapping("")
public class TopController {

	@Autowired
	TopService topService;
	
	@RequestMapping("/GetTopOneDocument")
	public @ResponseBody Document getMyDocument() throws Exception {
		return topService.getTopDocument();
	}
	
	@RequestMapping("/GetTopOneBook")
	public @ResponseBody Book getMyBook() throws Exception {
		return topService.getTopBook();
	}
	
	@RequestMapping("/GetTopOneCourse")
	public @ResponseBody Course getMyCourse() throws Exception {
		return topService.getTopCourse();
	}
}