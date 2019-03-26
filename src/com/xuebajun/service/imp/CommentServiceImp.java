package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.BookMapper;
import com.xuebajun.mapper.CommentMapper;
import com.xuebajun.mapper.CourseMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.ProfessorMapper;
import com.xuebajun.mapper.ReplyMapper;
import com.xuebajun.pojo.Book;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Course;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Professor;
import com.xuebajun.pojo.Reply;
import com.xuebajun.service.CommentService;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentMapper commentMapper;
	@Autowired
	ReplyMapper replyMapper;
	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	CourseMapper courseMapper;
	@Autowired
	BookMapper bookMapper;
	@Autowired
	ProfessorMapper professorMapper;
	
	@Override
	public void deleteByFather(Comment comment) {
		// TODO Auto-generated method stub
		
		// 得到要删除的评论列表
		Document d = new Document();
		d.setId(comment.getBelong());
		d = documentMapper.getMyCommentList(d);
		List<Comment> commentList = d.getCommentList();
		
		// 先删除从属的回复
		Reply r = new Reply();
		for(Comment c : commentList) {
			r.setBelong(c.getId());
			replyMapper.deleteByFather(r);
		}
		
		// 删除评论
		commentMapper.deleteByFather(comment);
	}

	@Override
	public void deleteById(Comment comment) {
		// TODO Auto-generated method stub
		
		// 先删除从属的回复
		Reply r = new Reply();
		r.setBelong(comment.getId());
		replyMapper.deleteByFather(r);
				
		commentMapper.deleteById(comment);
	}

	@Override
	public void add(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.add(comment);
		// 将对应对象的评论数+1
		String type = comment.getType();
		if(type.compareTo("document") == 0) {
			Document d = new Document();
			d.setId(comment.getBelong());
			documentMapper.plusCommentNumber(d);
		}else if(type.compareTo("course") == 0) {
			Course course = new Course();
			course.setId(comment.getBelong());
			courseMapper.plusCommentNumber(course);
		}else if(type.compareTo("book")==0) {
			Book book = new Book();
			book.setId(comment.getBelong());
			bookMapper.plusCommentNumber(book);
		}else if(type.compareTo("professor")==0) {
			Professor p = new Professor();
			p.setId(comment.getBelong());
			professorMapper.plusCommentNumber(p);
		}
	}

	@Override
	public void change(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.change(comment);
	}
	
	@Override
	public Comment getCommentById(Comment comment) {
		comment = commentMapper.getById(comment);
		comment.setReplyList(commentMapper.getMyReplyList(comment));
		return comment;
	}

	@Override
	public void addReply(Reply r) {
		// TODO Auto-generated method stub
		replyMapper.add(r);
	}
}
