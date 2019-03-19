package com.xuebajun.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xuebajun.controller.CollectController;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.News;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.User;
import com.xuebajun.service.BookService;
import com.xuebajun.service.CollectService;
import com.xuebajun.service.ConcernService;
import com.xuebajun.service.CourseService;
import com.xuebajun.service.DocumentService;
import com.xuebajun.service.NewsService;
import com.xuebajun.service.ProfessorService;
import com.xuebajun.service.TagService;
import com.xuebajun.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {
	
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
		book = bookService.getById(book);
		System.out.println("书籍信息：");
		System.out.println("返回书籍信息："+book.getName());
		System.out.println("相关课程信息："+book.getCourse().getName());
	}
	
	@Test (timeout = 1000)
	public void testGetProfessorById() {
		Professor p = new Professor();
		p.setId(2);
		p = professorService.getById(p);
		System.out.println("教师信息：");
		System.out.println("返回教师信息："+p.getIntro());
		System.out.println("相关课程信息："+p.getProfessorCourseList().get(0).getCourse().getName());
		System.out.println("相关评论信息："+p.getCommentList().get(0).getContent());
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

}
