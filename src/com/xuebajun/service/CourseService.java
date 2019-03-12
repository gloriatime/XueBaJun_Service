package com.xuebajun.service;

import com.xuebajun.pojo.Course;

public interface CourseService {
	public void add(Course course);
	public void delete(Course course);
	public Course getById(Course course);
}
