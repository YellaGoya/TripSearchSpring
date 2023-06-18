package com.ssafy.trip.attr.model;

public class CategoryDto {
	private int code;
	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CategoryDto [code=" + code + ", name=" + name + "]";
	}

}
