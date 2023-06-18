package com.ssafy.trip.comment.model;

public class CommentDto {
	int index;
	int articleNo;
	String userId;
	String content;
	String registerTime;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	@Override
	public String toString() {
		return "CommentDto [index=" + index + ", articleNo=" + articleNo + ", userId=" + userId + ", content=" + content
				+ ", registerTime=" + registerTime + "]";
	}
	
}
