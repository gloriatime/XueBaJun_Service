package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.TopDate;

public interface DocumentMapper {
	public void add(Document document);
	public void delete(Document document);
	public Document getById(Document document);
	public Document getMyCommentList(Document document);
	public List<Document> searchDocumentList(Document document);
	
	public Document getTopOne(TopDate topDate);
	public Document getLastOne();
}
