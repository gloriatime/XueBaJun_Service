package com.xuebajun.service;

import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Reply;

public interface CommentService {
	public void deleteByFather(Comment comment);
	public void deleteById(Comment comment);
	public void add(Comment comment);
	public void change(Comment comment);
	public Comment getCommentById(Comment comment);
	public void addReply(Reply r);
}
