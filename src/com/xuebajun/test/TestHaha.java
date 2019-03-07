package com.xuebajun.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.UserMapper;
import com.xuebajun.pojo.CollectBook;
import com.xuebajun.pojo.CollectCourse;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.User;
import com.xuebajun.service.AboutMeService;
import com.xuebajun.service.CommentService;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHaha {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private AboutMeService aboutMeService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private CommentService commentService;
	
	@Test
	public void testAdd() {
		User u = new User();
		//u.setName("头牌");
		//u.setGrade("大三");
		u.setPhone("18291024978");
		//u.setPwd("123");
		//u.setCollege("计算机");
		//u.setPoint(200);
		//userMapper.add(u);
		userService.addUser(u);
	}
	
	@Test
	public void testGetMyConcernList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userMapper.getMyConcernList(u);
		
			System.out.println(user.getPhone());
			List<Concern> concernList = user.getMyconcernlist();
			for(Concern concern:concernList) {
				System.out.println("  "+concern.getMy_concern().getName()+concern.getMy_concern().getPhone());
			}
		
	}
	@Test
	public void testGetConcernMeList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userMapper.getConcernMeList(u);
		
			System.out.println(user.getPhone());
			List<Concern> concernList = user.getConcern_me_list();
			for(Concern concern:concernList) {
				System.out.println("  "+concern.getUser().getName()+concern.getUser().getPhone());
			}
		
	}
	
	@Test
	public void testGetMyCollectedDocumentsList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userService.getCollectedDocuments(u);
		
			System.out.println(user.getPhone());
			List<CollectDocument> collectDocumentList = user.getCollected_documents();
			for(CollectDocument c:collectDocumentList) {
				System.out.println("  "+c.getDocument().getName()+"Id: "+c.getDocument().getId() +"Author:"+c.getDocument().getAuthor());
			}
		
	}
	
	@Test
	public void testGetMyCollectedBooksList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userMapper.getMyCollectedBooksList(u);
		
			System.out.println(user.getPhone());
			List<CollectBook> collectBookList = user.getCollected_books();
			for(CollectBook c:collectBookList) {
				System.out.println("  "+c.getBook().getName());
			}
		
	}
	
	@Test
	public void testGetMyCollectedCoursesList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userMapper.getMyCollectedCoursesList(u);
		
			System.out.println(user.getPhone());
			List<CollectCourse> collectCourseList = user.getCollected_courses();
			for(CollectCourse c:collectCourseList) {
				System.out.println("  "+c.getCourse().getName()+c.getCourse().getId());
			}
		
	}
	
	@Test
	public void testGetMydocumentList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userMapper.getMydocumentList(u);
		System.out.println(user.getPhone());
		List<Document> myDocument = user.getMyDocument();
		for(Document d:myDocument) {
			System.out.println("  "+d.getName()+d.getId());
		}
	}
	
	@Test
	public void testGetMyCommentList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = aboutMeService.getMyComment(u);
		System.out.println(user.getPhone());
			List<Comment> myComment = user.getMyComment();
			for(Comment c:myComment) {
				System.out.println("  "+c.getContent());
				System.out.println("    TO: "+c.getType());
				System.out.println("    	NAME: "+c.getDocument().getName());
			}
	}
	
	@Test
	public void testGetMyNewsList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = userMapper.getMyNewsList(u);
		System.out.println(user.getPhone());
		List<News> myDocument = user.getMyNews();
		for(News d:myDocument) {
			System.out.println("  "+d.getContent()+d.getId());
		}
	}
	
	@Test
	public void testAddDocument() {
		Document d = new Document();
		d.setUp_user("13061765432");
		d.setName("《巍无羡漫画头像》");
		d.setAuthor("清明");
		d.setUp_time(new Date());
		d.setUrl("document/test.jpg");
		documentService.add(d);
		
	}

	@Test
	public void testDeleteDocument() {
		// 只能删除存在的列，否则报错
		Document d = new Document();
		//d.setId(2);
		//documentService.delete(d);
		
	}
	
	@Test
	public void ChangeComment() {
		Comment c = new Comment();
		c.setId(5);
		c.setContent("我尿黄，让我来滋醒他");
		commentService.change(c);	
	}
	
	@Test
	public void SelectDocumentById() {
		Document d = new Document();
		d.setId(3);
		d = documentService.selectById(d);
		System.out.println("资料名："+d.getName());
		List<Comment> list = d.getCommentList();
		for(Comment c:list) {
			System.out.println("   评论："+c.getId()+c.getContent());
		}
		
	}
}

