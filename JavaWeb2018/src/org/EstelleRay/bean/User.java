package org.EstelleRay.bean;

public class User {
	private String stuId;
	private String stuName;
	private String password;
	private String avatar;
	private String gender;
	private String bio;
	private String gitUrl;
	
	//¹¹Ôìº¯Êý
	public User() {
		super();
	}
	public User(String stuId,String stuName,String password,String avatar,String gender,String bio,String gitUrl) {
		this.stuId = stuId;
		this.stuName = stuName;
		this.password = password;
		this.avatar = avatar;
		this.gender = gender;
		this.bio = bio;
		this.gitUrl = gitUrl;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getGitUrl() {
		return gitUrl;
	}
	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

}
