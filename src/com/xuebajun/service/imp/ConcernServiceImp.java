package com.xuebajun.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.ConcernMapper;
import com.xuebajun.pojo.Concern;
import com.xuebajun.service.ConcernService;

@Service
public class ConcernServiceImp implements ConcernService {

	@Autowired
	ConcernMapper concernMapper;
	@Override
	public void addConcern(Concern concern) {
		// TODO Auto-generated method stub
		concernMapper.add(concern);
	}

	@Override
	public void deleteConcern(Concern concern) {
		// TODO Auto-generated method stub
		concernMapper.deleteMyConcern(concern);
	}

	@Override
	public Concern HasConcerned(Concern concern) {
		// TODO Auto-generated method stub
		return concernMapper.hasConcerned(concern);
	}

}
