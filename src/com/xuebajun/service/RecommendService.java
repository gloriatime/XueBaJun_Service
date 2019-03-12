package com.xuebajun.service;

import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;

public interface RecommendService {
	// 主页显示的推荐表单
	public UserTag getRecommendList(User user);
	
}
