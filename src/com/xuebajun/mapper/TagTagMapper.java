package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;

public interface TagTagMapper {
	public void add(TagTag tagTag);
	public void deleteByBelong(TagTag tt);
	public List<Document> getDocumentListByTag(Tag tag);
	public List<Course> getCourseListByTag(Tag tag);
	public List<Book> getBookListByTag(Tag tag);
	
}
