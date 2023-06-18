package com.ssafy.trip.member.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.member.model.MemberDto;

@Mapper
public interface MemberMapper {
	int register(MemberDto memberDto) throws Exception;
	int registerPermission(Map<String, String> map) throws Exception;
	int modify(MemberDto memberDto) throws Exception;
	int modifyPwd(MemberDto memberDto) throws Exception;
	int delete(MemberDto memberDto) throws Exception;
	MemberDto login(MemberDto memberDto) throws Exception;
	String find(MemberDto memberDto) throws Exception;
	MemberDto userInfo(String userId) throws SQLException;
	void saveRefreshToken(Map<String, String> map) throws SQLException;
	Object getRefreshToken(String userId) throws SQLException;
	void deleteRefreshToken(Map<String, String> map) throws SQLException;
	
//	int modify(String curUserId, MemberDto memberDto) throws Exception;
//	int remove(String curUserId) throws Exception;
}
