package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.CollectBookMapper;
import com.xuebajun.mapper.CollectCourseMapper;
import com.xuebajun.mapper.CollectDocumentMapper;
import com.xuebajun.pojo.CollectBook;
import com.xuebajun.pojo.CollectCourse;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.service.CollectService;


@Service
public class CollectServiceImp implements CollectService{

	@Autowired
	CollectDocumentMapper collectDocumentMapper;
	@Autowired
	CollectBookMapper collectBookMapper;
	@Autowired
	CollectCourseMapper collectCourseMapper;

	@Override
	public void collectDocument(CollectDocument collectDocument) {
		// TODO Auto-generated method stub
		collectDocumentMapper.add(collectDocument);
	}

	@Override
	public void collectBook(CollectBook collectBook) {
		// TODO Auto-generated method stub
		collectBookMapper.add(collectBook);
	}

	@Override
	public void collectCourse(CollectCourse collectCourse) {
		// TODO Auto-generated method stub
		collectCourseMapper.add(collectCourse);
	}

	@Override
	public void deleteCollecedDocument(CollectDocument collectDocument) {
		// TODO Auto-generated method stub
		collectDocumentMapper.delete(collectDocument);
	}

	@Override
	public void deleteCollecedBook(CollectBook collectBook) {
		// TODO Auto-generated method stub
		collectBookMapper.delete(collectBook);
	}

	@Override
	public void deleteCollecedCourse(CollectCourse collectCourse) {
		// TODO Auto-generated method stub
		collectCourseMapper.delete(collectCourse);
	}

}
