package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.CourseMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.TopDate;
import com.xuebajun.service.TopService;

@Service
public class TopServiceImp implements TopService{

	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	BookMapper bookMapper;
	
	@Override
	public Document getTopDocument() {
		// TODO Auto-generated method stub
		TopDate topDate = new TopDate();
		Document d = new Document();
		d = documentMapper.getTopOne(topDate);
		// �������0���Ļ���ѡ�������ϴ���һ��
		if(d == null) {
			d = documentMapper.getLastOne();
		}
		return d;
	}

	@Override
	public Course getTopCourse() {
		// TODO Auto-generated method stub
		TopDate topDate = new TopDate();
		Course c = new Course();
		c = courseMapper.getTopOne(topDate);
		// �������0���Ļ���ѡ�������ϴ���һ��
		if(c == null) {
			c = courseMapper.getLastOne();
		}
		return c;
	}

	@Override
	public Book getTopBook() {
		// TODO Auto-generated method stub
		TopDate topDate = new TopDate();
		Book b = new Book();
		b = bookMapper.getTopOne(topDate);
		// �������0���Ļ���ѡ�������ϴ���һ��
		if(b == null) {
			b = bookMapper.getLastOne();
		}
		return b;
	}

}
