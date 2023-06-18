package com.ssafy.trip.member.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.member.model.MemberDto;
import com.ssafy.trip.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private MemberMapper memberMapper;

	@Autowired
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	
	@Override
	public int register(MemberDto memberDto) throws Exception {
		return memberMapper.register(memberDto);
	}
	

	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return memberMapper.login(memberDto);
	}


	@Override
	public String find(MemberDto memberDto) throws Exception {
		return memberMapper.find(memberDto);
	}


	@Override
	public MemberDto userInfo(String userId) throws Exception {
		return memberMapper.userInfo(userId);
	}


	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);
	}


	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return memberMapper.getRefreshToken(userId);
	}


	@Override
	public void deleteRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);
	}


	@Override
	public int modify(MemberDto memberDto) throws Exception {
		return memberMapper.modify(memberDto);
	}


	@Override
	public int delete(MemberDto memberDto) throws Exception {
		return memberMapper.delete(memberDto);
	}


	@Override
	public int modifyPwd(MemberDto memberDto) throws Exception {
		return memberMapper.modifyPwd(memberDto);
	}


	@Override
	public int registerPermission(String userId, String permission) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("permission", permission);
		return memberMapper.registerPermission(map);
	}
	

}
