package com.xuebajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.User;
import com.xuebajun.service.ConcernService;
import com.xuebajun.service.UserService;

@Controller
@RequestMapping("")
public class ConcernController {

	@Autowired
	UserService userService;
	@Autowired
	ConcernService concernService;
	
	@RequestMapping("/GetMyConcern")
	public @ResponseBody User getMyConcernList(@RequestBody User user){
		return userService.getMyConcernList(user);
	}
	
	@RequestMapping("/GetConcernMe")
	public @ResponseBody User getConcernMeList(@RequestBody User user){
		return userService.getConcernMeList(user);
	}
	
	@RequestMapping("/DeleteConcern")
	public void deleteConcern(@RequestBody Concern concern) {
		concernService.deleteConcern(concern);
	}
	
	@RequestMapping("/AddConcern")
	public void addConcern(@RequestBody Concern concern) {
		concernService.addConcern(concern);
	}
	
	// 检查是否已关注某用户
	// 有此关系就返回该关系，没有则返回null
	@RequestMapping("/HasConcerned")
	public @ResponseBody Concern hasConcerned(@RequestBody Concern concern) {
		return concernService.HasConcerned(concern);
	}
}
