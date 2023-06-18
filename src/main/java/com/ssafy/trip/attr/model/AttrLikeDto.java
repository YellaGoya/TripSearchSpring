package com.ssafy.trip.attr.model;

public class AttrLikeDto {
	String userId;
	String contentId;
	int value;
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getContentId() {
		return contentId;
	}


	public void setContentId(String contentId) {
		this.contentId = contentId;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "AttrLikeDto [userId=" + userId + ", contentId=" + contentId + ", value=" + value + "]";
	}
}
