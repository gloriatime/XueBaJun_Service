package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.ProfessorMapper;
import com.xuebajun.pojo.Professor;
import com.xuebajun.service.ProfessorService;

@Service
public class ProfessorServiceImp implements ProfessorService {

	@Autowired
	ProfessorMapper professorMapper;
	@Override
	public Professor getById(Professor p) {
		// TODO Auto-generated method stub
		// ��ȡ������Ϣ
		p = professorMapper.getById(p);
		// ��ȡ�����ڿγ�
		Professor temp = professorMapper.getProfessorCourseList(p);
		p.setProfessorCourseList(temp.getProfessorCourseList());
		// ��ȡ�������
		temp = professorMapper.getMyCommentList(p);
		p.setCommentList(temp.getCommentList());
		return p;
	}

}
