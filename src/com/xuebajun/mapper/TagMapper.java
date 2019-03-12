package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Tag;

public interface TagMapper {
	public void add(Tag tag);
	public List<Tag> getTagListByType(Tag tag);// ÍÆ¼öÏµÍ³
	public List<Tag> select(Tag tag);
	public void pulsOnetoTimes(Tag tag);
}
