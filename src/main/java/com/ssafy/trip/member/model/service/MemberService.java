package com.ssafy.trip.member.model.service;

import com.ssafy.trip.member.model.MemberDto;

public interface MemberService {
	int register(MemberDto memberDto) throws Exception;
	int registerPermission(String userId, String permission) throws Exception;
	int delete(MemberDto memberDto) throws Exception;
	int modify(MemberDto memberDto) throws Exception;
	int modifyPwd(MemberDto memberDto) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
	MemberDto userInfo(String userId) throws Exception;
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	void deleteRefreshToken(String userId) throws Exception;
	String find(MemberDto memberDto) throws Exception;
	
//	int modify(String curUserId, MemberDto memberDto) throws Exception;
//	int remove(String curUserId) throws Exception;
}
