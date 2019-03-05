package com.xuebajun.mapper;

import com.xuebajun.pojo.CollectCourse;

public interface CollectCourseMapper {
	// 收藏某课程
	public void add(CollectCourse collectCourse);
	// 取消收藏某课程
	public void delete(CollectCourse collectCourse);
}
