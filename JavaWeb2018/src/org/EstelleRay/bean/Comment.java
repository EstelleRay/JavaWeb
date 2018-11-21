package org.EstelleRay.bean;

import java.util.Date;

public class Comment {
	private int commentId;
	private String author;
	private String content;
	private int postId;
	private Date posttime;
	public Comment() {
		super();
	}
	public Comment(int commentId, String author, String content, int postId, Date posttime) {
		super();
		this.commentId = commentId;
		this.author = author;
		this.content = content;
		this.postId = postId;
		this.posttime = posttime;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
}
