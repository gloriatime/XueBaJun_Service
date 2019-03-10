package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;

public interface TagTagMapper {
	public List<Document> getDocumentListByTag(Tag tag);
	public List<Course> getCourseListByTag(Tag tag);
	public List<Book> getBookListByTag(Tag tag);
}
