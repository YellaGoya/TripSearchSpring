package com.ssafy.trip.member.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.trip.jwt.JwtServiceImpl;
import com.ssafy.trip.member.model.MemberDto;
import com.ssafy.trip.member.model.service.MemberService;
import com.ssafy.trip.response.model.ResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api("사용자 컨트롤러 API V1")
public class MemberController{

	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private MemberService memberService;
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	
	@GetMapping("/checkid/{userId}")
	@ApiOperation(value = "아이디 체크", notes = "아이디 중복을 체크한다.")
	public ResponseEntity<ResponseDto> idCehck(@PathVariable(value = "userId") @ApiParam(value = "중복 체크할 아이디") String userId) throws Exception{
		ResponseDto response = new ResponseDto();
		MemberDto memberDto = memberService.userInfo(userId);
		if(memberDto == null) { // 중복되지 않는 경우
			response.setResponseCode(600);
			response.setResponseMsg("아이디 사용 가능!!");
		} else { // 이미 존재하는 경우
			response.setResponseCode(700);
			response.setResponseMsg("아이디가 이미 존재!");
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value= "로그인", notes = "Access-token과 로그인 관련 결과 메세지를 반환한다.")
	@PostMapping("/login")
	public ResponseEntity<ResponseDto> login(@RequestBody @ApiParam(value = "로그인 시 필요한 회원 정보 (아이디, 비밀번호)", required=true) MemberDto memberDto) throws Exception{
		MemberDto userInfo = memberService.login(memberDto);
		ResponseDto response = new ResponseDto();
		
		if(userInfo != null) {
			String accessToken = jwtService.createAccessToken("userid", userInfo.getUserId());// key, data
			String refreshToken = jwtService.createRefreshToken("userid", userInfo.getUserId());// key, data
			memberService.saveRefreshToken(memberDto.getUserId(), refreshToken);
			
			logger.debug("로그인 accessToken 정보 : {}", accessToken);
			logger.debug("로그인 refreshToken 정보 : {}", refreshToken);
			
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("access-token", accessToken);
			data.put("refresh-token", refreshToken);
			
			response.setResponseCode(200);
			response.setResponseMsg("로그인 성공!");
			response.setData(data);
			
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
		
		response.setResponseCode(400);
		response.setResponseMsg("로그인에 실패 하였습니다.");
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value="회원인증", notes = "회원정보를 담은 Token을 반환한다.")
	@GetMapping("/info/{userId}")
	public ResponseEntity<ResponseDto> getInfo(@PathVariable("userId") @ApiParam(value = "인증할 회원의 아이디", required = true) String userId, HttpServletRequest request){
		ResponseDto response = new ResponseDto();
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if(jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			try {
				MemberDto memberDto = memberService.userInfo(userId);
				resultMap.put("userInfo", memberDto);
				response.setResponseCode(200);
				response.setResponseMsg("정보 조회 성공!");
				response.setData(resultMap);
				status = HttpStatus.ACCEPTED;
			} catch(Exception e) {
				logger.error("정보조회 실패 : {}", e);
				response.setResponseCode(400);
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용불가능한 토큰!!!");
			response.setResponseCode(400);
			response.setResponseMsg("사용 불가능한 토큰!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<ResponseDto>(response, status);
	}
	
	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.")
	@GetMapping("/logout/{userId}")
	public ResponseEntity<ResponseDto> removeToken(@PathVariable("userId") String userId){
		ResponseDto response = new ResponseDto();
		try {
			memberService.deleteRefreshToken(userId);
			response.setResponseCode(400);
//			logger.debug("로그아웃 성공");
			response.setResponseMsg("로그아웃 성공!");
		} catch (Exception e) {
			logger.debug("로그아웃 실패 : {}", e);
			response.setResponseCode(200);
			response.setResponseMsg("로그아웃 실패");
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	

	
	@ApiOperation(value= "Access Token 재발급", notes = "만료된 access token을 재발급받는다.")
	@PostMapping("/refresh")
	public ResponseEntity<ResponseDto> refreshToken(@RequestBody MemberDto memberDto, HttpServletRequest request) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		ResponseDto response = new ResponseDto();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token : {}, memberDto : {}", token, memberDto);
		if(jwtService.checkToken(token)) {
			if(token.equals(memberService.getRefreshToken(memberDto.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userId", memberDto.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				response.setResponseCode(400);
				response.setResponseMsg("Access Token 재 발급");
				response.setData(resultMap);
				status = HttpStatus.ACCEPTED;
			}
		} else {
			logger.debug("refreshToken도 사용 불가");
			status = HttpStatus.UNAUTHORIZED;
		}
		
		return new ResponseEntity<ResponseDto>(response, status);
		
	}
	
	// 회원가입 등록
	@PostMapping("/register")
	@ApiOperation(value= "회원가입", notes = "회원가입 함")
	public ResponseEntity<ResponseDto> register(@RequestBody MemberDto memberDto) throws Exception {
		ResponseDto response = new ResponseDto();
		try {
			memberService.register(memberDto);
			memberService.registerPermission(memberDto.getUserId(), "1");
			response.setResponseCode(200);
			response.setResponseMsg("회원가입 성공!!");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setResponseCode(400);
			response.setResponseMsg("회원가입 실패!!");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
	}
	
	// 회원정보 수정
	@PutMapping("/modify")
	@ApiOperation(value= "회원정보 수정", notes = "회원정보 수정하기")
	public ResponseEntity<ResponseDto> modify(@RequestBody MemberDto memberDto){
		ResponseDto response = new ResponseDto();
		try {
			MemberDto userInfo = memberService.login(memberDto);
			if(userInfo == null) {
				response.setResponseCode(401);
				response.setResponseMsg("비밀번호를 확인해주세요.");
				return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
			} else {
				memberService.modify(memberDto);
				response.setResponseCode(200);
				response.setResponseMsg("회원정보 수정 성공!!");
				return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
			}
		} catch (Exception e) {
			response.setResponseCode(400);
			response.setResponseMsg("회원정보 수정 실패!!");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
	}
	
	@PutMapping("/modifypwd")
	@ApiOperation(value = "회원 비밀번호 수정", notes = "회원 비밀번호 수정하기")
	public ResponseEntity<ResponseDto> modifyPwd(@RequestBody MemberDto memberDto) throws Exception{
		ResponseDto response = new ResponseDto();
		if(jwtService.getUserId().equals(memberDto.getUserId())) {
			try {
				memberService.modifyPwd(memberDto);
				response.setResponseCode(200);
				response.setResponseMsg("비밀번호 변경 성공");
			} catch(Exception e) {
				response.setResponseCode(400);
				response.setResponseMsg("비밀번호 변경 실패");
			}
			
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	@ApiOperation(value = "회원 탈퇴", notes= "회원정보 탈퇴하기")
	public ResponseEntity<ResponseDto> delete(@PathVariable("userId") String userId, HttpServletRequest request) throws Exception{
		ResponseDto response = new ResponseDto();
		MemberDto memberDto = new MemberDto();
		memberDto.setUserId(userId);
		
		
		if(jwtService.getUserId().equals(userId)) {
			memberService.delete(memberDto);
			response.setResponseCode(200);
			response.setResponseMsg("회원탈퇴 성공!!");
		} else {
			response.setResponseCode(400);
			response.setResponseMsg("회원탈퇴 실패!!");
		}
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	@GetMapping("/find")
	@ApiOperation(value = "비밀번호 찾기", notes = "비밀번호 찾기")
	public ResponseEntity<ResponseDto> find(MemberDto memberDto) throws Exception {
		ResponseDto response = new ResponseDto();
		
		String pass = memberService.find(memberDto);
		if(pass == null) { // 이메일이나 아이디가 다른 경우
			response.setResponseCode(400);
			response.setResponseMsg("비밀번호 변경 실패");
		} else {
			response.setResponseCode(200);
			response.setResponseMsg("비밀번호 변경 성공");
			Map<String, String> map = new HashMap<String, String>();
			map.put("password", pass);
			response.setData(map);
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	

	
	
}
