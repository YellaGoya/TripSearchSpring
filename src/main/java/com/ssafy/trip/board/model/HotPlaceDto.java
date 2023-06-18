package com.ssafy.trip.board.model;

public class HotPlaceDto {
	private int hotNo;
	private String hotName;
	private String visitedDate;
	private String hotContent;
	private String address;
	private String latitude;
	private String longitude;
	public int getHotNo() {
		return hotNo;
	}
	public void setHotNo(int hotNo) {
		this.hotNo = hotNo;
	}
	public String getHotName() {
		return hotName;
	}
	public void setHotName(String hotName) {
		this.hotName = hotName;
	}
	public String getVisitedDate() {
		return visitedDate;
	}
	public void setVisitedDate(String visitedDate) {
		this.visitedDate = visitedDate;
	}
	public String getHotContent() {
		return hotContent;
	}
	public void setHotContent(String hotContent) {
		this.hotContent = hotContent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "HotPlace [hotNo=" + hotNo + ", hotName=" + hotName + ", visitedDate=" + visitedDate + ", hotContent="
				+ hotContent + ", address=" + address + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	
}
