package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.NewsMapper;
import com.xuebajun.pojo.News;
import com.xuebajun.service.NewsService;

@Service
public class NewsServiceImp implements NewsService {

	@Autowired
	NewsMapper newsMapper;
	@Override
	public void add(News news) {
		// TODO Auto-generated method stub
		newsMapper.add(news);
	}

	@Override
	public void delete(News news) {
		// TODO Auto-generated method stub
		newsMapper.delete(news);
	}

}
