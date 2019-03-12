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
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.NewsService;
import com.xuebajun.service.RecommendService;

@Controller
@RequestMapping("")
public class RecommendController {
	
	@Autowired
	RecommendService recommendService;
	
	@RequestMapping("/GetRecommendListOfMainPage")
    public @ResponseBody UserTag getRecommendListOfMainPage(@RequestBody User user) {
		return recommendService.getRecommendList(user);
    }
	
	@RequestMapping("/GetRecommendListOfDocumentPage")
    public @ResponseBody Document getRecommendListOfDocumentPage(@RequestBody User user) {
		return recommendService.getRecommendDocumentList(user);
    }
	
	@RequestMapping("/GetRecommendListOfCoursePage")
    public @ResponseBody Course getRecommendListOfCoursePage(@RequestBody User user) {
		return recommendService.getRecommendCourseList(user);
    }
	
	@RequestMapping("/GetRecommendListOfBookPage")
    public @ResponseBody Book getRecommendListOfBookPage(@RequestBody User user) {
		return recommendService.getRecommendBookList(user);
    }
}
