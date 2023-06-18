package com.ssafy.trip.attr.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.trip.attr.model.AttrDto;
import com.ssafy.trip.attr.model.AttrLikeDto;
import com.ssafy.trip.attr.model.CategoryDto;
import com.ssafy.trip.attr.model.GugunDto;
import com.ssafy.trip.attr.model.SidoDto;

@Mapper
public interface AttrMapper {

	List<SidoDto> getSido() throws SQLException;

	List<GugunDto> getGugun(String sido) throws SQLException;

	List<CategoryDto> getCate() throws SQLException;

	List<AttrDto> byCategory_gugun(Map<String, Object> param) throws SQLException;
	
	String findDesc(String contentid) throws SQLException;

	AttrLikeDto isLike(AttrLikeDto attrLikeDto) throws Exception;
	
	int likeAttr(AttrLikeDto attrLikeDto) throws Exception;
	
	int insertLike(AttrLikeDto attrLikeDto) throws Exception;
	
	List<AttrDto> likeList(String userId) throws Exception;
	
	List<AttrDto> search(String searchWord) throws Exception;
	
	List<AttrDto> getHotPlace() throws Exception;
	
	List<AttrDto> getHotPlaceByCate(Map<String, String> map) throws Exception;
}