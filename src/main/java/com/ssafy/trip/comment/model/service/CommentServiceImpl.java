package com.ssafy.trip.comment.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.comment.model.CommentDto;
import com.ssafy.trip.comment.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentMapper commentMapper;
	
	@Autowired
	public CommentServiceImpl(CommentMapper commentMapper) {
		super();
		this.commentMapper = commentMapper;
	}



	@Override
	public List<CommentDto> commentList(String articleNo) throws Exception {
		return commentMapper.commentList(articleNo);
	}



	@Override
	public int insertComment(CommentDto commentDto) throws Exception {
		return commentMapper.insertComment(commentDto);
	}



	@Override
	public int deleteComment(String index) throws Exception {
		return commentMapper.deleteComment(index);
	}

}
