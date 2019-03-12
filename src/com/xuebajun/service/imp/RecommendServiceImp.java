package com.xuebajun.service.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.TagMapper;
import com.xuebajun.mapper.TagTagMapper;
import com.xuebajun.mapper.UserTagMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.RecommendService;

@Service
public class RecommendServiceImp implements RecommendService {

	@Autowired
	TagTagMapper tagTagMapper;
	@Autowired
	TagMapper tagMapper;
	@Autowired
	UserTagMapper userTagMapper;
	
	List<Document> documents = new ArrayList<>();
	List<Course> courses = new ArrayList<>();
	List<Book> books = new ArrayList<>();
	
	@Override
	public UserTag getRecommendList(User user) {
		// TODO Auto-generated method stub
		
		// ��ʼ��
		documents.clear();
		courses.clear();
		books.clear();
		
		// ����User�õ�����Ȥ�����ر�ǩ
		if(user.isArt() == true) {
			setList("art");
		}
		
		if(user.isAgriculture() == true) {
			setList("agriculture");
		}
		
		if(user.isHumanity() == true) {
			setList("humanity");
		}
		
		if(user.isManagement() == true) {
			setList("management");
		}
		
		if(user.isMedicine() == true) {
			setList("medicine");
		}
		
		if(user.isPlay() == true) {
			setList("play");
		}
		
		if(user.isTechnology() == true) {
			setList("technology");
		}
		
		
		// ȥ��
		HashSet h = new HashSet(documents);
		documents.clear();
		documents.addAll(h);
		h.clear();
		
		h.addAll(courses);
		courses.clear();
		courses.addAll(h);
		h.clear();
		
		//courses.stream().distinct().collect(Collectors.toList());
		
		h.addAll(books);
		books.clear();
		books.addAll(h);
		h.clear();
		
		// ��װ����
		UserTag ut = new UserTag();
		ut.setRecommendDocumentList(documents);
		ut.setRecommendBookList(books);
		ut.setRecommendCourseList(courses);
		
		return ut;
	}
	
	
	private void setList(String tagType) {
		List<Tag> temp = new ArrayList<>();
		Tag t = new Tag();
		t.setType(tagType);
		temp = tagMapper.getTagListByType(t);
		for(Tag tag:temp) {
			documents.addAll(tagTagMapper.getDocumentListByTag(tag));
			courses.addAll(tagTagMapper.getCourseListByTag(tag));
			books.addAll(tagTagMapper.getBookListByTag(tag));
		}
	}


	@Override
	public Document getRecommendDocumentList(User user) {
		// TODO Auto-generated method stub
		
		List<Document> recommendList = new ArrayList<>();
		
		// �ȵõ��û��Ӵ����ı�ǩ�б�
		UserTag ut =new UserTag();
		List<UserTag> temp = userTagMapper.getUserTagByUser(ut);
		// ͨ����ǩ�õ��Ƽ��б�
		for(UserTag userTag:temp) {
			Tag t =new Tag();
			t.setId(userTag.getTag());
			recommendList.addAll(tagTagMapper.getDocumentListByTag(t));
		}
		// ȥ��
		HashSet h = new HashSet(recommendList);
		recommendList.clear();
		recommendList.addAll(h);
		h.clear();
		
		Document d = new Document();
		d.setRecommendList(recommendList);
		
		return d;
	}


	@Override
	public Course getRecommendCourseList(User user) {
		// TODO Auto-generated method stub
		List<Course> recommendList = new ArrayList<>();
		
		// �ȵõ��û��Ӵ����ı�ǩ�б�
		UserTag ut =new UserTag();
		List<UserTag> temp = userTagMapper.getUserTagByUser(ut);
		// ͨ����ǩ�õ��Ƽ��б�
		for(UserTag userTag:temp) {
			Tag t =new Tag();
			t.setId(userTag.getTag());
			recommendList.addAll(tagTagMapper.getCourseListByTag(t));
		}
		// ȥ��
		HashSet h = new HashSet(recommendList);
		recommendList.clear();
		recommendList.addAll(h);
		h.clear();
		
		Course c = new Course();
		c.setRecommendList(recommendList);
		
		return c;
	}


	@Override
	public Book getRecommendBookList(User user) {
		// TODO Auto-generated method stub
		List<Book> recommendList = new ArrayList<>();
		
		// �ȵõ��û��Ӵ����ı�ǩ�б�
		UserTag ut =new UserTag();
		List<UserTag> temp = userTagMapper.getUserTagByUser(ut);
		// ͨ����ǩ�õ��Ƽ��б�
		for(UserTag userTag:temp) {
			Tag t =new Tag();
			t.setId(userTag.getTag());
			recommendList.addAll(tagTagMapper.getBookListByTag(t));
		}
		// ȥ��
		HashSet h = new HashSet(recommendList);
		recommendList.clear();
		recommendList.addAll(h);
		h.clear();
		
		Book b = new Book();
		b.setRecommendList(recommendList);
		
		return b;
	}


}
