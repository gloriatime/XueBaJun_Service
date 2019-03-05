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
public class ChangeInfoController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/ChangeName")
	public void changeName(@RequestBody User user) throws Exception {
		userService.changeName(user);
	}
	
	@RequestMapping("/ChangeGrade")
	public void changeGrade(@RequestBody User user) {
		userService.changeGrade(user);
	}
	
	@RequestMapping("/ChangeCollege")
	public void changeCollege(@RequestBody User user) {
		userService.changeCollege(user);
	}
	
	@RequestMapping("/ChangePwd")
	public void changePwd(@RequestBody User user) {
		userService.changePwd(user);
	}
	
	@RequestMapping("/ChangeInterest")
	public void changeInterestv(@RequestBody User user) {
		userService.changeInterest(user);
	}
}
