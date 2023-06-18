package com.ssafy.trip.comment.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.trip.comment.model.CommentDto;

@Service
public interface CommentService {
	
	List<CommentDto> commentList(String articleNo) throws Exception;

	int insertComment(CommentDto commentDto) throws Exception;
	
	int deleteComment(String index) throws Exception;
}
