package com.xuebajun.mapper;

import java.util.List;

import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Reply;

public interface CommentMapper {
	public void add(Comment comment);
	public void deleteById(Comment comment);
	public void deleteByFather(Comment comment);
	public Comment getMyReplyList(Comment comment);
	public void change(Comment comment);
	public Comment getById(Comment comment);
}
