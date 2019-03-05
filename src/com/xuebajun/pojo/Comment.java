package com.xuebajun.pojo;

import java.util.Date;
import java.util.List;

public class Comment {
	private int id;
	private User critic;
	private Date date;
	private String type;
	private int belong;
	// 暂时不知道comment是对什么的评论
	private String Content;
	private Document document;
	private Book book;
	private Course course;
	// 还有一个teacher。
	
	// 从属的回复列表
	private List<Reply> replyList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getCritic() {
		return critic;
	}
	public void setCritic(User critic) {
		this.critic = critic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBelong() {
		return belong;
	}
	public void setBelong(int belong) {
		this.belong = belong;
	}
	public List<Reply> getReplyList() {
		return replyList;
	}
	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}
}
