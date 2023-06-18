package com.ssafy.trip.comment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.board.controller.BoardController;
import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.comment.model.CommentDto;
import com.ssafy.trip.comment.model.service.CommentService;
import com.ssafy.trip.response.model.ResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/comment")
@Api("댓글 컨트롤러 API V1")
public class CommentController {
	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	private CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping("/{articleNo}")
	@ApiOperation(value = "글 댓글 불러오기", notes = "글번호에 맞는 댓글 불러오기")
	public ResponseEntity<ResponseDto> commentList(@PathVariable @ApiParam(value = "게시글 번호", required=true) String articleNo){
		ResponseDto response = new ResponseDto();
		try{
			logger.debug("view articleNo : {}", articleNo);
			List<CommentDto> data = commentService.commentList(articleNo);
			response.setData(data);
			response.setResponseCode(200);
			response.setResponseMsg("댓글 불러오기 성공!");
			
		} catch(Exception e) {
			response.setResponseCode(400);
			response.setResponseMsg("댓글 불러오던 중 오류가 발생했습니다.");
			logger.debug(e.toString());
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	@PostMapping("/write")
	@ApiOperation(value = "댓글 작성하기", notes = "댓글 작성하기")
	public ResponseEntity<ResponseDto> insertComment(@RequestBody @ApiParam(value = "댓글 내용", required=true) CommentDto commentDto){
		ResponseDto response = new ResponseDto();
		try{
			if(commentService.insertComment(commentDto) > 0) {
				response.setResponseCode(200);
				response.setResponseMsg("댓글 작성 성공!");
			}
		} catch(Exception e) {
			response.setResponseCode(400);
			response.setResponseMsg("댓글 작성 중 오류가 발생했습니다.");
			logger.debug(e.toString());
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{index}")
	@ApiOperation(value = "댓글 삭제하기", notes = "댓글 삭제하기")
	public ResponseEntity<ResponseDto> deleteComment(@PathVariable @ApiParam(value = "댓글 인덱스", required=true) String index){
		ResponseDto response = new ResponseDto();
		try{
			if(commentService.deleteComment(index) > 0) {
				response.setResponseCode(200);
				response.setResponseMsg("댓글 삭제 성공!");
			}
		} catch(Exception e) {
			response.setResponseCode(400);
			response.setResponseMsg("댓글 삭제 중 오류가 발생했습니다.");
			logger.debug(e.toString());
		}
		
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
}
