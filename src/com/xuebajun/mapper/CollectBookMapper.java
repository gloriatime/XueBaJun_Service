package com.xuebajun.mapper;

import com.xuebajun.pojo.CollectBook;

public interface CollectBookMapper {
	// 收藏某书籍
	public void add(CollectBook collectBook);
	// 取消收藏某书籍
	public void delete(CollectBook collectBook);
}
