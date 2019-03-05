package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.User;
import com.xuebajun.service.AboutMeService;

@Controller
@RequestMapping("")
public class AboutMeController {
	@Autowired
	AboutMeService aboutMeService;
	
	@RequestMapping("/GetMyDocument")
	public @ResponseBody User getMyDocument(@RequestBody User user) throws Exception {
		return aboutMeService.getMyDocument(user);
	}
	
	@RequestMapping("/GetMyComment")
	public @ResponseBody User getMyComment(@RequestBody User user) throws Exception {
		return aboutMeService.getMyComment(user);
	}
	
	@RequestMapping("/GetMyNews")
	public @ResponseBody User getMyNews(@RequestBody User user) throws Exception {
		return aboutMeService.getMyNews(user);
	}
}
