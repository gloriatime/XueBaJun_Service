package com.xuebajun.service.imp;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.CollectDocumentMapper;
import com.xuebajun.mapper.CommentMapper;
import com.xuebajun.mapper.DocumentMapper;
import com.xuebajun.pojo.CollectDocument;
import com.xuebajun.pojo.Comment;
import com.xuebajun.pojo.Document;
import com.xuebajun.service.CommentService;
import com.xuebajun.service.DocumentService;

@Service
public class DocumentServiceImp implements DocumentService {

	@Autowired
	DocumentMapper documentMapper;
	@Autowired
	CommentService commentService;
	@Autowired
	CollectDocumentMapper collectDocumentMapper;
	
	@Override
	public void add(Document d) {
		// TODO Auto-generated method stub
		documentMapper.add(d);
	}
	
	// ɾ������ʵ���ͬʱ��Ҫɾ���ղظ����ϵĹ�ϵ,���ڸ��ĵ�������Ҳ����������
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
		
		documentMapper.delete(d);
		
	}

	@Override
	public Document selectById(Document d) {
		// TODO Auto-generated method stub
		d = documentMapper.getById(d);
		Document temp = new Document();
	
		temp = documentMapper.getMyCommentList(d);
		List<Comment> commentList = temp.getCommentList();
		
		d.setCommentList(commentList);
			
		return d;
	}

}
