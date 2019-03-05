package com.xuebajun.mapper;

import com.xuebajun.pojo.Concern;

public interface ConcernMapper {
	public void add(Concern concern);
	public void deleteMyConcern(Concern concern);
	// 检查该用户是否为已关注对象
	public Concern HasConcerned(Concern concern);

}
