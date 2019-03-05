package com.xuebajun.mapper;

import com.xuebajun.pojo.Reply;

public interface ReplyMapper {
	public void add(Reply reply);
	public void deleteById(Reply reply);
	public void deleteByFather(Reply reply);
}
