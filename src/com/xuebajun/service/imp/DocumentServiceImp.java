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
	
	// 添加资料同时添加其对应的标签关系
	// 并且将标签引用次数+1
	// 以及该用户某标签浏览次数+10（使用某标签1次=浏览某标签10次）
	@Override
	public void add(Document d) {
		// TODO Auto-generated method stub
		// 需要获取d的Id才能为其贴标签
		documentMapper.add(d);
		System.out.println("document插入后自增Id返回："+d.getId());
		
		TagTag tt = new TagTag();
		tt.setBelong(d.getId());
		tt.setType("document");
		List<Tag> tagList = d.getTagList();
		for(Tag t:tagList) {
			
			// 添加对应标签关系
			tt.setTag(t.getId());
			tagTagMapper.add(tt);
			
			// 标签引用次数+1
			tagMapper.pulsOnetoTimes(t);
			
			// 更改用户标签关系
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
	
	// 删除资料实体的同时需要删除收藏该资料的关系,关于该文档的评论以及标签关系
	@Override
	public void delete(Document d) {
		// TODO Auto-generated method stub
		
		CollectDocument cd = new CollectDocument();
		cd.setDocument(d);
		collectDocumentMapper.deleteByDocumentId(cd);
		
		// 根据资料的URL删除服务器中文件
		d = documentMapper.getById(d);
		String url = "/data/wwwroot/default/XueBaJun/"+d.getUrl();
		System.out.println(url);
		File file = new File(url);
		if(file.exists()) {
			file.delete();
		}
		
		// 删除从属评论及其回复
		Comment c = new Comment();
		c.setBelong(d.getId());
		c.setType("‘document’");
		commentService.deleteByFather(c);
		
		// 删除其标签关系
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
