package com.ssafy.trip.comment.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.comment.model.CommentDto;

@Mapper
public interface CommentMapper {
	List<CommentDto> commentList(String articleNo) throws Exception;
	int insertComment(CommentDto commentDto) throws Exception;
	int deleteComment(String index) throws Exception;
}
