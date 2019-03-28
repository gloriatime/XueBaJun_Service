package com.xuebajun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuebajun.mapper.TagTagMapper;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.NewsService;
import com.xuebajun.service.RecommendService;
import com.xuebajun.service.TagService;

@Controller
@RequestMapping("")
public class TagController {
	
	@Autowired
	TagService tagService;
	
	
	
	// 模糊查询查找标签
	@RequestMapping("/GetTagListByLike")
    public @ResponseBody Tag getRecommendListOfMainPage(@RequestBody Tag tag) {
		return tagService.getTagList(tag);
    }
	
	// 添加标签
	@RequestMapping("/AddTag")
	public @ResponseBody Tag addTag(@RequestBody Tag tag) {
		return tagService.add(tag);
	}
	
	// 添加标签引用次数
	@RequestMapping("/PlusOneToTimes")
	public void plusOneToTimes(@RequestBody Tag tag) {
		 tagService.pulsOnetoTimes(tag);
	}
	
	// 贴标签   标签引用次数自动+1
	@RequestMapping("/TagToDocument")
	public void tagToDocument(@RequestBody TagTag tt) {
		tagService.addTagTag(tt);
	}
	
	// 用户标签联系 如果没有该联系会自动添加
	@RequestMapping("/UserTagPlusTen")
	public void userTagPlusTen(@RequestBody UserTag ut) {
		tagService.userTagPlusTen(ut);
	}
	
	
}
