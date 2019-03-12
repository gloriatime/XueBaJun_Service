package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.UserTag;

public interface UserTagMapper {
	public void add(UserTag ut);
	public UserTag getUserTag(UserTag ut);
	
	public void pulsOnetoTimes(UserTag ut);
	public void pulsTentoTimes(UserTag ut);
}
