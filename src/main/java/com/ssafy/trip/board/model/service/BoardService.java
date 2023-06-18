package com.ssafy.trip.board.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.board.model.BoardParamDto;
import com.ssafy.trip.board.model.HotPlaceDto;
import com.ssafy.trip.common.util.PageNavigation;

@Service
public interface BoardService {
	int write(BoardDto boardDto) throws Exception;
	
	List<BoardDto> listBoard(BoardParamDto param) throws Exception;
	
	int getTotalArticle(BoardParamDto param) throws Exception;
	
//	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
	
	BoardDto detail(String articleNo) throws Exception;
	
	void updateHit(int articleNo) throws Exception;

	int delete(String articleNo) throws Exception;
	
	int modify(BoardDto boardDto) throws Exception;
//	int hotplaceRegister(HotPlaceDto hotplaceDto) throws Exception;
	
	int like(BoardDto boardDto) throws Exception;
	
	
	int writeWithConId(BoardDto boardDto) throws Exception;
}
