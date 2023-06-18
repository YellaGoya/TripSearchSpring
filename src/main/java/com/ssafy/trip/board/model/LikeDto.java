package com.ssafy.trip.board.model;

public class LikeDto {

	private int articleNo;
	private String userId;
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
	@Override
	public String toString() {
		return "LikeDto [articleNo=" + articleNo + ", userId=" + userId + "]";
	}
	
	
	
}
