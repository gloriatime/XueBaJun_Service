package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.TagMapper;
import com.xuebajun.mapper.TagTagMapper;
import com.xuebajun.mapper.UserTagMapper;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.TagService;

@Service
public class TagServiceImp implements TagService {

	@Autowired
	TagMapper tagMapper;
	@Autowired
	TagTagMapper tagTagMapper;
	@Autowired
	UserTagMapper userTagMapper;
	
	@Override
	public Tag add(Tag tag) {
		// TODO Auto-generated method stub
		tagMapper.add(tag);
		return tag;
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
	
	@Override
	public void addTagTag(TagTag tt) {
		
		tt.setType("document");
		tagTagMapper.add(tt);
		
		Tag t = new Tag();
		t.setId(tt.getBelong());
		// 标签引用次数+1
		tagMapper.pulsOnetoTimes(t);
	}
	
	@Override
	public void userTagPlusTen(UserTag ut) {	
		UserTag temp = userTagMapper.getUserTag(ut);
		if(temp!=null) {
			userTagMapper.pulsTentoTimes(ut);
		}else {
			ut.setTimes(10);
			userTagMapper.add(ut);
		}
	}

}
