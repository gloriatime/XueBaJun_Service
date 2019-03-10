package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.News;
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
}
