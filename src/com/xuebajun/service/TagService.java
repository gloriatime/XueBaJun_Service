package com.xuebajun.service;

import java.util.List;

import com.xuebajun.pojo.Tag;
import com.xuebajun.pojo.TagTag;
import com.xuebajun.pojo.UserTag;

public interface TagService {
	public Tag add(Tag tag);
	// �ϴ��ļ�ʱѡ���ǩ����---ģ����ѯ��ǩ�б�
	public Tag getTagList(Tag tag);
	public void pulsOnetoTimes(Tag tag);
	void addTagTag(TagTag tt);
	void userTagPlusTen(UserTag ut);
}
