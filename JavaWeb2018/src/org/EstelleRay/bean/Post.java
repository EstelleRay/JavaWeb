package org.EstelleRay.bean;

import java.sql.Date;

public class Post {
	private int postId;
	private String author;
	private String title;
	private String content;
	private Date posttime;
	private int pv;
	
	public Post() {
		super();
	}
	public Post(int postId, String author,String title,String content,Date posttime,int pv) {
		super();
		
		this.postId = postId;
		this.author = author;
		this.title = title;
		this.content = content;
		this.posttime = posttime;
		this.pv = pv;
	}
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPosttime() {
		return posttime;
	}
	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}
	public int getPv() {
		return pv;
	}
	public void setPv(int pv) {
		this.pv = pv;
	}
}
