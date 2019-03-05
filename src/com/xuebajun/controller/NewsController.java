package com.xuebajun.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.UploadFile;
import com.xuebajun.pojo.User;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.NewsService;

@Controller
@RequestMapping("")
public class NewsController {

	@Autowired
	NewsService newsService;

    @RequestMapping("/AddNews")
    public void addNews(@RequestBody News news) {
    	newsService.add(news);
    }

    @RequestMapping("/DeleteNews")
    public void deleteNews(@RequestBody News news) {
    	newsService.delete(news);
    }
}
