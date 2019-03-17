package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.TopDate;

public interface CourseMapper {
	public void add(Course course);
	public void delete(Course course);
	public Course getById(Course course);
	
	public Course getProfessorCourseList(Course course);
	public Course getTagList(Course course);
	public Course getMyCommentList(Course course);
	
	public List<Course> searchCourseList(Course course);
	
	public Course getTopOne(TopDate topDate);
	public Course getLastOne();
	public List<Course> getTopTwenty(TopDate topDate);
}
