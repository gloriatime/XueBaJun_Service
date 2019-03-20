package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.ScoreService;

@Controller
@RequestMapping("")
public class ScoreController {
	
	@Autowired
	ScoreService scoreService;
	
	@RequestMapping("/ScoreBook")
    public @ResponseBody Book scoreBook(@RequestBody Book book) {
		return scoreService.scoreBook(book);
    }
	
	@RequestMapping("/ScoreCourse")
    public @ResponseBody Course scoreCourse(@RequestBody Course course) {
		return scoreService.scoreCourse(course);
    }
	
	@RequestMapping("/ScoreDocument")
    public @ResponseBody Document scoreDocument(@RequestBody Document d) {
		return scoreService.scoreDocument(d);
    }
	
	@RequestMapping("/ScoreProfessor")
    public @ResponseBody Professor scoreProfessor(@RequestBody Professor p) {
		return scoreService.scoreProfessor(p);
    }
	
}
