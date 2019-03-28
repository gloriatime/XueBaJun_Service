package com.xuebajun.service;

import java.util.List;

import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.UserTag;

public interface TagService {
	public Tag add(Tag tag);
	// 上传文件时选择标签功能---模糊查询标签列表
	public Tag getTagList(Tag tag);
	public void pulsOnetoTimes(Tag tag);
	void addTagTag(TagTag tt);
	void userTagPlusTen(UserTag ut);
}
