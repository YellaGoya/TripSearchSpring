package com.ssafy.trip.member.model;

public class MemberDto {
	private String userId;
	private String userName;
	private String userPwd;
	private String emailId;
	private String emailDomain;
	private String joinDate;
	private int age;
	private String gender;
	private String token;
	private String permission;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "MemberDto [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", emailId="
				+ emailId + ", emailDomain=" + emailDomain + ", joinDate=" + joinDate + ", age=" + age + ", gender="
				+ gender + ", token=" + token + ", permission=" + permission + "]";
	} 
	
	
}
