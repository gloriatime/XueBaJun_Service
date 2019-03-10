package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Tag;

public interface TagMapper {
	public List<Tag> getTagListByType(Tag tag);
}
