package com.xuebajun.pojo;

import java.util.List;

public class Course {
	private int Id;
	private String name;
	private String term;
	private String intro;
	private float score;
	private int number;
	private int comment;
	
	// 所属评论列表
	private List<Comment> commentList;
	
	// 搜索功能
	private List<Course> courseList;
	
	// 推荐功能--猜你喜欢
	private List<Course> recommendList;
	
	// 20热门
	private List<Course> topTwentyList;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	// 重写相同判别法，过滤推荐列表中的相同元素
	@Override 
	public int hashCode() {
		return Id;
	}
	@Override
    public boolean equals(Object x){
        if(this.getClass() != x.getClass())
            return false;
        Course c = (Course)x;
        return this.Id == c.Id;
    }
	public List<Course> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<Course> recommendList) {
		this.recommendList = recommendList;
	}
	public List<Course> getTopTwentyList() {
		return topTwentyList;
	}
	public void setTopTwentyList(List<Course> topTwentyList) {
		this.topTwentyList = topTwentyList;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

}
