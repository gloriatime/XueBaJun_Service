package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.CourseMapper;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.service.CourseService;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	CourseMapper courseMapper;
	
	@Override
	public void add(Course course) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course course) {
		// TODO Auto-generated method stub

	}

	@Override
	public Course getById(Course course) {
		// TODO Auto-generated method stub
		course = courseMapper.getById(course);
		System.out.println("返回课程信息："+course.getName());
		Course temp = new Course();
	
		temp = courseMapper.getMyCommentList(course);
		course.setCommentList(temp.getCommentList());
		
		temp = courseMapper.getTagList(course);
		if(temp.getTagList()!=null) {
			course.setTagList(temp.getTagList());
		}
		
		temp = courseMapper.getProfessorCourseList(course);
		course.setProfessorCourseList(temp.getProfessorCourseList());
						
		return course;
	}

}
