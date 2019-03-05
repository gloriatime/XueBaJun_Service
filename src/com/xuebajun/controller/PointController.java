package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.User;
import com.xuebajun.service.UserService;

@Controller
@RequestMapping("")
public class PointController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/CheckIn")
	public @ResponseBody User CheckIn(@RequestBody User user)throws Exception{
		return userService.checkIn(user);
	}
}
