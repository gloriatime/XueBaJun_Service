package com.xuebajun.mapper;

import com.xuebajun.pojo.Concern;

public interface ConcernMapper {
	public void add(Concern concern);
	public void deleteMyConcern(Concern concern);
	// �����û��Ƿ�Ϊ�ѹ�ע����
	public Concern hasConcerned(Concern concern);

}
