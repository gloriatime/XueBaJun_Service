package com.xuebajun.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.UserMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.CollectBook;
import com.xuebajun.pojo.CollectCourse;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.AboutMeService;
import com.xuebajun.service.CommentService;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.RecommendService;
import com.xuebajun.service.SearchService;
import com.xuebajun.service.TagService;
import com.xuebajun.service.TopService;
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
	@Autowired
	private SearchService searchService;
	@Autowired
	private TopService topService;
	@Autowired
	private RecommendService recommendService;
	@Autowired
	private TagService tagService;
	
	@Test(timeout = 1000)
	public void testAdd() {
		User u = new User();
		//u.setName("ͷ��");
		//u.setGrade("����");
		u.setPhone("18291024978");
		//u.setPwd("123");
		//u.setCollege("�����");
		//u.setPoint(200);
		//userMapper.add(u);
		//userService.addUser(u);
	}
	
	@Test(timeout = 1000)
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
	@Test(timeout = 1000)
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
	
	@Test(timeout = 1000)
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
	
	@Test(timeout = 1000)
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
	
	@Test(timeout = 1000)
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
	
	@Test(timeout = 1000)
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
	
	@Test(timeout = 1000)
	public void testGetMyCommentList() {
		User u = new User();
		u.setPhone("13061765432");
		User user = aboutMeService.getMyComment(u);
		System.out.println(user.getPhone());
			List<Comment> myComment = user.getMyComment();
			for(Comment c:myComment) {
				System.out.println("  "+c.getContent());
				System.out.println("    TO: "+c.getType());
				// ���Ը����ϵ����ۣ���������������������Ҫ�ı䷽��
				//System.out.println("    	NAME: "+c.getDocument().getName());
			}
	}
	
	@Test(timeout = 1000)
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
	
	@Test(timeout = 1000)
	public void testAddDocument() {
		Document d = new Document();
		d.setUp_user("13061765432");
		d.setName("�������ļ�2");
		d.setAuthor("ߣ�����2");
		d.setUp_time(new Date());
		d.setUrl("document/test.jpg");
		
		// ����ļ���ǩ
		List<Tag> tagList = new ArrayList<>();
		Tag tag1 = new Tag();
		Tag tag2 = new Tag();
		tag1.setId(13);
		tagList.add(tag1);
		tag2.setId(14);
		tagList.add(tag2);
		d.setTagList(tagList);
		
		//documentService.add(d);
		
	}

	@Test(timeout = 1000)
	public void testDeleteDocument() {
		// ֻ��ɾ�����ڵ��У����򱨴�
		Document d = new Document();
		d.setId(57);
		//documentService.delete(d);
		
	}
	
	@Test(timeout = 1000)
	public void ChangeComment() {
		Comment c = new Comment();
		c.setId(5);
		c.setContent("����ƣ�������������");
		commentService.change(c);	
	}
	
	@Test(timeout = 1000)
	public void SelectDocumentById() {
		Document d = new Document();
		d.setId(2);
		d.setApplicant("13061765432");
		d = documentService.selectById(d);
		System.out.println("��������"+d.getName());
		List<Comment> list = d.getCommentList();
		for(Comment c:list) {
			System.out.println("   ���ۣ�"+c.getId()+c.getContent()+c.getCritic().getPhone());
		}
		for(Tag t:d.getTagList()) {
			System.out.println("   ��ǩ��"+t.getName()+t.getTimes());
		}
		
	}
	
	@Test(timeout = 1000)
	public void testSearch() {
		Course c = new Course();
		c.setName("ҽ");		
		c = searchService.searchCourse(c);
		List<Course> result = c.getCourseList();
		System.out.println("�������ݷ��أ�");
		for(Course course:result) {
			System.out.println(" "+course.getId());
			System.out.println(" "+course.getName());
			System.out.println("   "+course.getIntro());
		}
	}
	
	@Test(timeout = 1000)
	public void testGetTopOne() {
		Document d = new Document();
		d = topService.getTopDocument();
		System.out.println("Top1���أ�");
		// �����Ҷ���0���ۻ���������ϴ���һ��
		System.out.println(" "+d.getName());
		
	}
	
	@Test(timeout = 1000)
	public void testGetRecommendListOfMainPage() {
		User u = new User();
		u.setPhone("13061765432");
		u.setTechnology(true);
		u.setArt(true);
		UserTag ut = new UserTag();
		ut = recommendService.getRecommendList(u);
		List<Document> documents = ut.getRecommendDocumentList();
		List<Course> courses = ut.getRecommendCourseList();
		
		System.out.println("�Ƽ����ϣ�");
		for(Document d:documents) {
			System.out.println(" "+d.getName());
		}
		System.out.println("�Ƽ��γ̣�");
		for(Course c:courses) {
			System.out.println(" "+c.getName());
		}
	}
	
	@Test(timeout = 1000)
	public void testGetTopTwenty() {
		Book book = topService.getTopTwentyBook();
		List<Book> bookList = book.getTopTwentyList();
		System.out.println("����20�鼮��");
		for(Book b:bookList) {
			System.out.println(" "+b.getName());
		}
	}
	
	@Test(timeout = 1000)
	public void testGetRecommendListOfBookPage() {
		User u = new User();
		u.setPhone("13061765432");
		System.out.println("���Ի��Ƽ��鼮�б�");
		Book book = recommendService.getRecommendBookList(u);
		for(Book b:book.getRecommendList()) {
			System.out.println(b.getName()+b.getAuthor()+b.getId());
		}
	}
	
	@Test (timeout = 1000)
	public void testTagSearch() {
		Tag tag = new Tag();
		tag.setName("��");
		tag = tagService.getTagList(tag);
		System.out.println("ģ����ѯ��ǩ��");
		for(Tag t:tag.getTagList()) {
			System.out.println(t.getName());
		}
	}
	
	@Test (timeout = 1000)
	public void testTagPlusTimes() {
		Tag tag = new Tag();
		tag.setId(6);
		//tagService.pulsOnetoTimes(tag);
	}
	
	@Test (timeout = 1000)
	public void testAddTag() {
		Tag tag = new Tag();
		tag.setName("�����ñ�ǩ");
		tag.setType("all");
		//tag = tagService.add(tag);
		//System.out.println("��ӱ�ǩ��������Id��"+tag.getId());
	}
	
	@Test (timeout = 1000)
	public void testTagTag() {
		TagTag tt = new TagTag();
		tt.setTag(22);
		tt.setBelong(2);
		//tagService.addTagTag(tt);
	}
	
	
}