package com.xuebajun.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuebajun.mapper.UserMapper;
import com.xuebajun.pojo.Concern;
import com.xuebajun.pojo.User;
import com.xuebajun.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserMapper userMapper;
	
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		int result = userMapper.add(user);
		if(result > 0) {
			return true;
		}else {
			return false;
		}
		
	}

	
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		User u = new User();
		u = userMapper.selectByPhone(user.getPhone());
		if(u.getPwd().compareTo(user.getPwd()) == 0) {
			return u;
		}else {
			return null;
		}
		
	}

	// 签到加8分
	@Override
	public User checkIn(User user) {
		// TODO Auto-generated method stub
		user.setPoint(user.getPoint() + 8);
		userMapper.changePoint(user);
		return user;
	}


	@Override
	public User changeName(User user) {
		// TODO Auto-generated method stub
		userMapper.changeName(user);
		return null;
	}


	@Override
	public User changeGrade(User user) {
		// TODO Auto-generated method stub
		userMapper.changeGrade(user);
		return null;
	}


	@Override
	public User changeCollege(User user) {
		// TODO Auto-generated method stub
		userMapper.changeCollege(user);
		return null;
	}


	@Override
	public User changePwd(User user) {
		// TODO Auto-generated method stub
		userMapper.changePwd(user);
		return null;
	}


	@Override
	public User changeInterest(User user) {
		// TODO Auto-generated method stub
		userMapper.changeInterest(user);
		return null;
	}


	@Override
	public User getMyConcernList(User user) {
		// TODO Auto-generated method stub
		// 清理返回列表中用户的密码
		user = userMapper.getMyConcernList(user);
		List<Concern> list = user.getMyconcernlist();
		for(Concern c:list) {
			c.getMy_concern().setPwd("");
		}
		return user;
	}


	@Override
	public User getConcernMeList(User user) {
		// TODO Auto-generated method stub
		// 清理返回列表中用户的密码
		user = userMapper.getConcernMeList(user);
		List<Concern> list = user.getConcern_me_list();
		for(Concern c:list) {
			c.getUser().setPwd("");
		}
		return user;
	}


	@Override
	public User getCollectedDocuments(User user) {
		// TODO Auto-generated method stub
		return userMapper.getMyCollectedDocumentsList(user);
	}


	@Override
	public User getCollectedBooks(User user) {
		// TODO Auto-generated method stub
		return userMapper.getMyCollectedBooksList(user);
	}


	@Override
	public User getCollectedCourses(User user) {
		// TODO Auto-generated method stub
		return userMapper.getMyCollectedCoursesList(user);
	}

}
