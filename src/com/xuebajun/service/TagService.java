package com.xuebajun.service;

import java.util.List;

import com.xuebajun.pojo.Tag;

public interface TagService {
	public void add(Tag tag);
	// �ϴ��ļ�ʱѡ���ǩ����---ģ����ѯ��ǩ�б�
	public Tag getTagList(Tag tag);
	public void pulsOnetoTimes(Tag tag);
}
