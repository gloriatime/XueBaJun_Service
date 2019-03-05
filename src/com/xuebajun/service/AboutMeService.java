package com.xuebajun.service;

import com.xuebajun.pojo.User;

public interface AboutMeService {
	public User getMyDocument(User user);
	public User getMyComment(User user);
	public User getMyNews(User user);
}
