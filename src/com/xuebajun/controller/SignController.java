package com.xuebajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.xuebajun.pojo.User;
import com.xuebajun.service.UserService;

@Controller
@RequestMapping("")
public class SignController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/SignIn")
	public @ResponseBody User SignIn(@RequestBody User user)throws Exception{
		
		if(userService.addUser(user)==true) {
			return user;
		}else {
			return null;
		}
	}
	
	// 核对密码成功就返回该用户信息，不成功就返回null
	@RequestMapping("/SignUp")
	public @ResponseBody User SignUp(@RequestBody User user)throws Exception{
		
		User u = userService.checkUser(user);
		return u;
	}
	
    @RequestMapping("/ShowResult")
    public @ResponseBody User getOne() {
         User u = new User();
         	u.setName("gloria");
 			u.setGrade("大三");
 			u.setPhone("13700201789");
 			u.setPwd("123");
         JSONObject json= new JSONObject();
         json.put("user", JSONObject.toJSON(u));
         //return json.toJSONString();
         return u;
    }
}
