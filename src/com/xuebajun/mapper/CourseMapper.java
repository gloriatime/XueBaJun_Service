package com.xuebajun.mapper;

import com.xuebajun.pojo.Course;

public interface CourseMapper {
	public void add(Course course);
	public void delete(Course course);
	public Course getById(Course course);
}
