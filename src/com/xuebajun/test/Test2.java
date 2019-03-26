package com.xuebajun.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuebajun.controller.CollectController;
import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.ProfessorCourseMapper;
import com.xuebajun.mapper.TagTagMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.ProfessorCourse;
import com.xuebajun.pojo.Reply;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.User;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CollectService;
import com.xuebajun.service.CommentService;
import com.xuebajun.service.ConcernService;
import com.xuebajun.service.CourseService;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.NewsService;
import com.xuebajun.service.ProfessorService;
import com.xuebajun.service.RecommendService;
import com.xuebajun.service.ScoreService;
import com.xuebajun.service.SearchService;
import com.xuebajun.service.TagService;
import com.xuebajun.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {
	@Autowired
	private SearchService searchService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private BookService bookService;
	@Autowired
    ProfessorService professorService;
	@Autowired
	ConcernService concernService;
	@Autowired
	UserService userService;
	@Autowired
	CollectService collectService;
	@Autowired
    DocumentService documentService;
	@Autowired
    NewsService newsService;
	@Autowired
	private RecommendService recommendService;
	
	@Autowired
	BookMapper bookMapper;

	
	@Test (timeout = 1000)
	public void testGetCourseById() {
		Course course = new Course();
		course.setId(3);
		course.setApplicant("13061765432");
		course = courseService.getById(course);
		System.out.println("课程信息：");
		System.out.println("返回课程信息："+course.getName());
		System.out.println("相关书籍信息："+course.getBook().getName());
		System.out.println("相关教师信息："+course.getProfessorCourseList().get(0).getProfessor().getName());
	}
	
	@Test 
	public void testGetBookById() {
		Book book = new Book();
		book.setId(3);
		book.setApplicant("13061765432");
		book = bookService.getById(book);
		
		System.out.println("书籍信息：");
		System.out.println("返回书籍信息："+book.getName());
		System.out.println("相关课程信息："+book.getCourse().getName());
		System.out.println("相关评论信息："+book.getCommentList().get(0).getContent());
	}
	

	@Test 
	public void testGetDocumentById() {
		Document d = new Document();
		
		d.setId(2);
		d.setApplicant("13061765432");
		d = documentService.selectById(d);
		
		System.out.println("资料信息：");
		System.out.println("返回资料信息："+d.getName());
		
	}
	
	@Test (timeout = 1000)
	public void testGetProfessorById() {
		Professor p = new Professor();
		p.setId(2);
		p = professorService.getById(p);
		System.out.println("教师信息：");
		System.out.println("返回教师信息："+p.getName());
		System.out.println("相关课程信息："+p.getProfessorCourseList().get(0).getCourse().getName());
		//System.out.println("相关评论信息："+p.getCommentList().get(0).getContent());
	}
	
	@Test (timeout = 1000)
	public void testUserTag() {
		Course course = new Course();
		course.setId(3);
		course.setApplicant("13061765432");
		course = courseService.getById(course);
		
	}
	
	@Test (timeout = 1000)
	public void testAddConcern() {
		Concern c = new Concern();
		User user = new User();
		user.setPhone("18291024979");
		User myconcern = new User();
		myconcern.setPhone("13061765432");
		c.setUser(user);
		c.setMy_concern(myconcern);
		Concern temp = new Concern();
		temp = concernService.HasConcerned(c);
		if(temp!=null) {
			System.out.println("已存在该关系");
		}else {
			concernService.addConcern(c);
		}
		
	}
	
	@Test (timeout = 1000)
	public void testSendNews() {
		CollectDocument cd = new CollectDocument();
		User user = new User();
		user.setPhone("13061765432");
		Document document = new Document();
		document.setId(6);
		cd.setUser(user);
		cd.setDocument(document);

		// 复制控制器中的部分
		/*collectService.collectDocument(cd);
		User u = cd.getUser();
		Document d = documentService.selectById(cd.getDocument());
		u = userService.getByPhone(u);
		User temp = userService.getConcernMeList(u);
		News n = new News();
		for(Concern concern:temp.getConcern_me_list()) {
			n.setBelong(concern.getUser());
			n.setContent("(｡･∀･)ﾉﾞ嗨~我是 "+u.getName()+" ,我刚刚收藏了资料 "+d.getName()+" ,你也来看看吧。");
			newsService.add(n);
		}*/
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
		
		System.out.println("推荐资料：");
		for(Document d:documents) {
			System.out.println(" "+d.getName());
		}
		System.out.println("推荐课程：");
		for(Course c:courses) {
			System.out.println(" "+c.getName());
		}
	}
	
	@Test(timeout = 1000)
	public void testSignUp() {
		User u = new User();
		u.setPhone("13061765432");
		u.setPwd("12345");
		u = userService.checkUser(u);
		
		System.out.println(" "+u.getName());
	}
	
	@Test(timeout = 1000)
	public void testSearch() {
		Book d = new Book();
		d.setName("");		
		//d = searchService.searchBook(d);
		//List<Book> result = d.getBookList();
		List<Book> result = bookMapper.searchBookList(d);
		System.out.println("搜索数据返回：");
		for(Book course:result) {
			System.out.println(" "+course.getId());
			System.out.println(" "+course.getName());
		}
	}
	@Autowired
	ScoreService scoreService;
	@Test(timeout = 1000)
	public void testScore() {
	Document d= new Document();
	d.setId(2);
	d.setScore(3);
	d = scoreService.scoreDocument(d);
		
		System.out.println("最后得分"+d.getScore());
	}
	
	@Autowired
	CommentService commentService;
	@Test(timeout = 1000)
	public void testADDComment() {
		//Comment c = new Comment();
		
		//c.setContent("我尿黄，让我来滋醒他");
		//User u = new User();
		//u.setPhone("13061765432");
		
		//c.setCritic(u);
		//c.setBelong(2);
		//c.setType("document");
		
		//commentService.add(c);	
		
		Reply r =new Reply();
		User u = new User();
		u.setPhone("18291024979");
		r.setCritic(u);
		User a = new User();
		a.setPhone("13061765432");
		r.setAt(a);
		r.setContent("滋滋滋");
		r.setBelong(2);
		//commentService.addReply(r);
	}
	
	@Test(timeout = 1000)
	public void testReply() {
		Comment c = new Comment();
		c.setId(2);
		
		c = commentService.getCommentById(c);
		System.out.println("评论信息"+c.getId()+c.getCritic().getName()+c.getContent());
		List<Reply> list = c.getReplyList();
		for(Reply r:list) {
			System.out.println("回复信息"+r.getId()+r.getCritic().getName()+r.getAt().getName());
		}
	}

}
