package com.xuebajun.mapper;

import com.xuebajun.pojo.CollectDocument;

public interface CollectDocumentMapper {
	// �ղ�ĳ����
	public void add(CollectDocument collectDocument);
	// ȡ���ղ�ĳ����
	public void delete(CollectDocument collectDocument);
	// ȡ������ĳ���ϵ������ղع�ϵ
	public void deleteByDocumentId(CollectDocument collectDocument);

}
