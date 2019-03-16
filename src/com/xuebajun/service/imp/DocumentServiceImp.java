package com.xuebajun.service.imp;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.CollectDocumentMapper;
import com.xuebajun.mapper.CommentMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.mapper.TagMapper;
import com.xuebajun.mapper.TagTagMapper;
import com.xuebajun.mapper.UserTagMapper;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Document;
import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.UserTag;
import com.xuebajun.service.CommentService;
import com.xuebajun.service.DocumentService;

@Service
public class DocumentServiceImp implements DocumentService {

	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	TagTagMapper tagTagMapper;
	@Autowired
	TagMapper tagMapper;
	@Autowired
	UserTagMapper userTagMapper;
	@Autowired
	CommentService commentService;
	@Autowired
	CollectDocumentMapper collectDocumentMapper;
	
	// �������ͬʱ������Ӧ�ı�ǩ��ϵ
	// ���ҽ���ǩ���ô���+1
	// �Լ����û�ĳ��ǩ�������+10��ʹ��ĳ��ǩ1��=���ĳ��ǩ10�Σ�
	@Override
	public void add(Document d) {
		// TODO Auto-generated method stub
		// ��Ҫ��ȡd��Id����Ϊ������ǩ
		documentMapper.add(d);
		System.out.println("document���������Id���أ�"+d.getId());
		
		TagTag tt = new TagTag();
		tt.setBelong(d.getId());
		tt.setType("document");
		List<Tag> tagList = d.getTagList();
		for(Tag t:tagList) {
			
			// ��Ӷ�Ӧ��ǩ��ϵ
			tt.setTag(t.getId());
			tagTagMapper.add(tt);
			
			// ��ǩ���ô���+1
			tagMapper.pulsOnetoTimes(t);
			
			// �����û���ǩ��ϵ
			UserTag ut = new UserTag();
			ut.setUser(d.getUp_user());
			ut.setTag(t.getId());
			UserTag temp = userTagMapper.getUserTag(ut);
			if(temp!=null) {
				userTagMapper.pulsTentoTimes(ut);
			}else {
				ut.setTimes(10);
				userTagMapper.add(ut);
			}
		}
	}
	
	// ɾ������ʵ���ͬʱ��Ҫɾ���ղظ����ϵĹ�ϵ,���ڸ��ĵ��������Լ���ǩ��ϵ
	@Override
	public void delete(Document d) {
		// TODO Auto-generated method stub
		
		CollectDocument cd = new CollectDocument();
		cd.setDocument(d);
		collectDocumentMapper.deleteByDocumentId(cd);
		
		// �������ϵ�URLɾ�����������ļ�
		d = documentMapper.getById(d);
		String url = "/data/wwwroot/default/XueBaJun/"+d.getUrl();
		System.out.println(url);
		File file = new File(url);
		if(file.exists()) {
			file.delete();
		}
		
		// ɾ���������ۼ���ظ�
		Comment c = new Comment();
		c.setBelong(d.getId());
		c.setType("��document��");
		commentService.deleteByFather(c);
		
		// ɾ�����ǩ��ϵ
		TagTag tt = new TagTag();
		tt.setBelong(d.getId());
		tt.setType("document");
		tagTagMapper.deleteByBelong(tt);
		
		documentMapper.delete(d);
		
	}

	@Override
	public Document selectById(Document d) {
		// TODO Auto-generated method stub
		d = documentMapper.getById(d);
		Document temp = new Document();
	
		temp = documentMapper.getMyCommentList(d);
		
		temp = documentMapper.getTagList(d);
		
			
		return temp;
	}

}
