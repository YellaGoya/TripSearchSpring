package com.ssafy.trip.board.model;


public class BoardDto {
	private String groupId;
	private int articleNo;
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private int like;
	private int contentId;
	private String contentTitle;
	
	public String getContentTitle() {
		return contentTitle;
	}
	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	@Override
	public String toString() {
		return "BoardDto [groupId=" + groupId + ", articleNo=" + articleNo + ", userId=" + userId + ", userName="
				+ userName + ", subject=" + subject + ", content=" + content + ", hit=" + hit + ", registerTime="
				+ registerTime + ", like=" + like + ", contentId=" + contentId + ", contentTitle=" + contentTitle + "]";
	}
	
}
