package com.ssafy.trip.attr.model;

public class AttrDto {
	private String contentid;
	private String image;
	private String title;
	private String addr;
	private float latitude;
	private float longitude;
	private String content;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentid() {
		return contentid;
	}

	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "AttrDto [contentid=" + contentid + ", image=" + image + ", title=" + title + ", addr=" + addr
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", content=" + content + "]";
	}

}
