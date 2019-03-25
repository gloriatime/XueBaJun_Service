package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Reply;
import com.xuebajun.pojo.User;
import com.xuebajun.service.AboutMeService;
import com.xuebajun.service.CommentService;

@Controller
@RequestMapping("")
public class CommentController {

	@Autowired
	CommentService commentService;
	@Autowired
	AboutMeService aboutMeService;

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
    
    @RequestMapping("/GetComment")
    public @ResponseBody Comment getComment(@RequestBody Comment comment) {
    	return commentService.getCommentById(comment);
    }
    
    @RequestMapping("/AddReply")
    public void addReply(@RequestBody Reply reply) {
    	commentService.addReply(reply);
    }
}
