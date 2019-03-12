package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.TagMapper;
import com.xuebajun.pojo.Tag;
import com.xuebajun.service.TagService;

@Service
public class TagServiceImp implements TagService {

	@Autowired
	TagMapper tagMapper;
	
	@Override
	public void add(Tag tag) {
		// TODO Auto-generated method stub
		tagMapper.add(tag);
	}

	@Override
	public Tag getTagList(Tag tag) {
		// TODO Auto-generated method stub
		Tag t = new Tag();
		t.setTagList(tagMapper.select(tag));
		return t;
	}

	@Override
	public void pulsOnetoTimes(Tag tag) {
		// TODO Auto-generated method stub
		tagMapper.pulsOnetoTimes(tag);
	}

}
