package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xuebajun.pojo.Comment;
import com.xuebajun.service.CommentService;

@Controller
@RequestMapping("")
public class CommentController {

	@Autowired
	CommentService commentService;

    @RequestMapping("/DeleteComment")
    public void deleteComment(@RequestBody Comment comment) {
    	commentService.deleteById(comment);
    }
    
    @RequestMapping("/AddComment")
    public void addComment(@RequestBody Comment comment) {
    	commentService.add(comment);
    }
    
    @RequestMapping("/ChangeComment")
    public void changeComment(@RequestBody Comment comment) {
    	commentService.change(comment);
    }
}
