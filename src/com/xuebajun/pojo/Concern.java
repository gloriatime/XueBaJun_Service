package com.xuebajun.pojo;

public class Concern {
	
	private User user;// 关注者
	private User my_concern;// 被关注的人
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getMy_concern() {
		return my_concern;
	}
	public void setMy_concern(User my_concern) {
		this.my_concern = my_concern;
	}
	
	
}
