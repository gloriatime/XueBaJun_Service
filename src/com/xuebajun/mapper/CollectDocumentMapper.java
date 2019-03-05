package com.xuebajun.mapper;

import com.xuebajun.pojo.CollectDocument;

public interface CollectDocumentMapper {
	// 收藏某资料
	public void add(CollectDocument collectDocument);
	// 取消收藏某资料
	public void delete(CollectDocument collectDocument);
	// 取消关于某资料的所有收藏关系
	public void deleteByDocumentId(CollectDocument collectDocument);

}
