package com.xuebajun.service;

import java.util.List;

import com.xuebajun.pojo.Tag;

public interface TagService {
	public void add(Tag tag);
	// 上传文件时选择标签功能---模糊查询标签列表
	public Tag getTagList(Tag tag);
	public void pulsOnetoTimes(Tag tag);
}
