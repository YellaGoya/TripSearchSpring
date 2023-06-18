package com.ssafy.trip.board.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.board.model.BoardParamDto;

@Mapper
public interface BoardMapper {
	int write(BoardDto boardDto) throws Exception;
	
	List<BoardDto> listBoard(BoardParamDto param) throws Exception;
	
	int getTotalArticleCount(BoardParamDto  param) throws SQLException;
	
	BoardDto detail(String articleNo) throws Exception;
	
	void updateHit(int articleNo) throws Exception;

	
	int delete(String articleNo) throws Exception;
	
	int modify(BoardDto boardDto) throws Exception;
	
	int likeVisited(BoardDto boardDto) throws SQLException;
	
	int updateLike(int articleNo) throws SQLException;
	
	int writeWithConId(BoardDto boardDto) throws Exception;
//	int hotplaceRegister(HotPlaceDto hotplaceDto) throws Exception;
}
