package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.CommentMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.ReplyMapper;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Document;
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
	
	@Override
	public void deleteByFather(Comment comment) {
		// TODO Auto-generated method stub
		
		// �õ�Ҫɾ���������б�
		Document d = new Document();
		d.setId(comment.getBelong());
		d = documentMapper.getMyCommentList(d);
		List<Comment> commentList = d.getCommentList();
		
		// ��ɾ�������Ļظ�
		Reply r = new Reply();
		for(Comment c : commentList) {
			r.setBelong(c.getId());
			replyMapper.deleteByFather(r);
		}
		
		// ɾ������
		commentMapper.deleteByFather(comment);
	}

	@Override
	public void deleteById(Comment comment) {
		// TODO Auto-generated method stub
		
		// ��ɾ�������Ļظ�
		Reply r = new Reply();
		r.setBelong(comment.getId());
		replyMapper.deleteByFather(r);
				
		commentMapper.deleteById(comment);
	}

	@Override
	public void add(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.add(comment);
	}

	@Override
	public void change(Comment comment) {
		// TODO Auto-generated method stub
		commentMapper.change(comment);
	}
}
