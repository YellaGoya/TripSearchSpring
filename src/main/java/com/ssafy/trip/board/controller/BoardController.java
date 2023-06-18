package com.ssafy.trip.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.board.model.BoardParamDto;
import com.ssafy.trip.board.model.service.BoardService;
import com.ssafy.trip.response.model.ResponseDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러 API V1")
public class BoardController{

	private final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "게시판 글 불러오기", notes = "group에 따라 해당 게시판 글들을 불러옴.")
	public ResponseEntity<ResponseDto> listBoard(@ApiParam(value = "게시글을 얻기 위한 부가 정보.", required=true) BoardParamDto boardParameter) throws Exception {
		logger.debug("listBoard() 실행!");
		System.out.println(boardParameter);
		List<BoardDto> list = boardService.listBoard(boardParameter);
		int totalSize = boardService.getTotalArticle(boardParameter);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("list", list);
		data.put("totalSize", totalSize);
		ResponseDto response = new ResponseDto();
		response.setData(data);
		response.setResponseCode(200);
		response.setResponseMsg("게시글 리스트");
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}

	@GetMapping("/view/{articleNo}")
	@ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.")
	public ResponseEntity<ResponseDto> detail(@PathVariable @ApiParam(value = "게시글 번호", required=true) String articleNo) throws Exception{
		logger.debug("view articleNo : {}", articleNo);
		BoardDto boardDto = boardService.detail(articleNo);
		boardService.updateHit(Integer.parseInt(articleNo));
		ResponseDto response = new ResponseDto();
		logger.debug("boardDto : {}", boardDto);
		if(boardDto != null) {
			response.setResponseCode(200);
			response.setData(boardDto);
			response.setResponseMsg("게시글");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
		response.setResponseCode(400);
		response.setResponseMsg("데이터를 찾을 수 없습니다.");
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	
	 @PostMapping("/write")
	    @ApiOperation(value = "게시판 글 쓰기", notes = "게시판에 글을 작성한다.")
	    public ResponseEntity<ResponseDto> write(
	            @RequestBody @ApiParam(value = "작성할 글 정보", required = true) BoardDto boardDto) throws Exception {
	        ResponseDto response = new ResponseDto();
	        if (boardDto.getContentId() != 0) {
	        	logger.debug("컨텐츠 아이디 있는경우 !");
	            if (boardService.writeWithConId(boardDto) > 0) {
	                response.setResponseCode(200);
	                response.setResponseMsg("글 등록에 성공하였습니다.");
	                return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	            }
	        } else {
	            if (boardService.write(boardDto) > 0) {

	                response.setResponseCode(200);
	                response.setResponseMsg("글 등록에 성공하였습니다.");
	                return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	            }
	        }

	        response.setResponseCode(400);
	        response.setResponseMsg("글 등록에 실패하였습니다.");
	        return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);

	    }
	
	@DeleteMapping("/delete/{articleno}")
	@ApiOperation(value= "게시판 글 지우기", notes="글번호에 해당하는 글을 지운다.")
	public ResponseEntity<ResponseDto> delete(@PathVariable @ApiParam(value="지울 글 번호", required=true) String articleno) throws Exception{
		ResponseDto response = new  ResponseDto();
		logger.debug("delete articleNo : {}", articleno);
		if(boardService.delete(articleno) > 0) {
			response.setResponseCode(200);
			response.setResponseMsg("해당 게시글을 지우기 성공.");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
		
		response.setResponseCode(400);
		response.setResponseMsg("해당 게시글을 지울 수 없습니다.");
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	
	@PutMapping("/modify")
	@ApiOperation(value= "게시판 글 수정하기", notes="글번호에 해당하는 글을 수정한다.")
	public ResponseEntity<ResponseDto> modify(@RequestBody @ApiParam(value="수정할 글 정보", required=true) BoardDto boardDto) throws Exception{
		ResponseDto response = new ResponseDto();
		
		if(boardService.modify(boardDto) > 0) { 
			response.setResponseCode(200);
			response.setResponseMsg("글 수정 성공.");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
		
		response.setResponseCode(400);
		response.setResponseMsg("글 수정 실패.");
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
	}
	
	@PostMapping("/like")
	@ApiOperation(value= "게시판 글 좋아하기", notes="글번호에 해당하는 글을 좋아하기")
	public ResponseEntity<ResponseDto> like(@RequestBody @ApiParam(value= "좋아할 글 정보") BoardDto boardDto) throws Exception{
		ResponseDto response = new ResponseDto();
		if(boardService.like(boardDto) > 0) {
			response.setResponseCode(200);
			response.setResponseMsg("게시글 좋아하기 성공.");
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK); 
		}
		
		response.setResponseCode(400);
		response.setResponseMsg("좋아하기는 한 번만 가능합니다.");
		return new ResponseEntity<ResponseDto>(response, HttpStatus.OK); 
	}
	
	
}
