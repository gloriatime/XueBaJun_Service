package com.xuebajun.service;

import com.xuebajun.pojo.Document;

public interface DocumentService {
	public void add(Document d);
	public void delete(Document d);
	public Document selectById(Document d);
}
