package com.ssafy.trip.response.model;

public class ResponseDto {
	int responseCode;
	String responseMsg;
	Object data;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseDto [responseCode=" + responseCode + ", responseMsg=" + responseMsg + ", data=" + data + "]";
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	
	
}
