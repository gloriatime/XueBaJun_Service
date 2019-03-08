package com.xuebajun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.service.SearchService;

@Controller
@RequestMapping("")
public class SearchController {

	@Autowired
	SearchService searchService;
	
	@RequestMapping("/SearchCourse")
    public @ResponseBody Course searchCourse(@RequestBody Course course) {
    	return searchService.searchCourse(course);
    }
	
	@RequestMapping("/SearchDocument")
    public @ResponseBody Document searchDocument(@RequestBody Document document) {
    	return searchService.searchDocument(document);
    }
	
	@RequestMapping("/SearchBook")
    public @ResponseBody Book searchBook(@RequestBody Book book) {
    	return searchService.searchBook(book);
    }
}
