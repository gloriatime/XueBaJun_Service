package com.xuebajun.mapper;

import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Professor;

public interface ProfessorMapper {
	public Professor getProfessorCourseList(Professor p);
	public Professor getById(Professor p);
	public Professor getMyCommentList(Professor p);
	public void score(Professor p);
}
