package com.xuebajun.service;

import com.xuebajun.pojo.CollectBook;
import com.xuebajun.pojo.CollectCourse;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.User;

public interface CollectService {
	
	// �����ղ�
	public void collectDocument(CollectDocument collectDocument);
	
	public void collectBook(CollectBook collectBook);
	
	public void collectCourse(CollectCourse collectCourse);
	
	// ȡ���ղ�
	public void deleteCollecedDocument(CollectDocument collectDocument);
	
	public void deleteCollecedBook(CollectBook collectBook);
	
	public void deleteCollecedCourse(CollectCourse collectCourse);
}
