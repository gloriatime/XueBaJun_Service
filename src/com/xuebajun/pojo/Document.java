package com.xuebajun.pojo;

import java.util.Date;
import java.util.List;

public class Document {
	private int Id;
	private String name = "û����";
	private String author = "����";
	private String up_user;
	private Date up_time = new Date();
	private float score;
	private int number;
	private int comment;
	private int download;
	private String url;
	
	// ���������б�
	private List<Comment> commentList;
	
	// ��������
	private List<Document> documentList;
	
	// ��Ӧ��ǩ����
	private List<Tag> tagList;
	
	// �Ƽ�����--����ϲ��
	private List<Document> recommendList;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUp_user() {
		return up_user;
	}
	public void setUp_user(String up_user) {
		this.up_user = up_user;
	}
	public Date getUp_time() {
		return up_time;
	}
	public void setUp_time(Date up_time) {
		this.up_time = up_time;
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
	public int getDownload() {
		return download;
	}
	public void setDownload(int download) {
		this.download = download;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Comment> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}
	public List<Document> getDocumentList() {
		return documentList;
	}
	public void setDocumentList(List<Document> documentList) {
		this.documentList = documentList;
	}
	
	// ��д��ͬ�б𷨣������Ƽ��б��е���ͬԪ��
		@Override 
		public int hashCode() {
			return Id;
		}
		@Override
	    public boolean equals(Object x){
	        if(this.getClass() != x.getClass())
	            return false;
	        Document d = (Document)x;
	        return this.Id == d.Id;
	    }
		public List<Tag> getTagList() {
			return tagList;
		}
		public void setTagList(List<Tag> tagList) {
			this.tagList = tagList;
		}
		public List<Document> getRecommendList() {
			return recommendList;
		}
		public void setRecommendList(List<Document> recommendList) {
			this.recommendList = recommendList;
		}

}
