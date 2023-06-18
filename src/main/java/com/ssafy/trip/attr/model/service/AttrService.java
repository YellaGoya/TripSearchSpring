package com.ssafy.trip.attr.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.trip.attr.model.AttrDto;
import com.ssafy.trip.attr.model.AttrLikeDto;
import com.ssafy.trip.attr.model.CategoryDto;
import com.ssafy.trip.attr.model.GugunDto;
import com.ssafy.trip.attr.model.SidoDto;

public interface AttrService {
	List<SidoDto> getSido() throws Exception;
	List<GugunDto> getGugun(String city) throws Exception;
	List<CategoryDto> getCate() throws Exception;
	List<AttrDto> byCategory(String sido, String gugun, String cate) throws Exception;
	String findDesc(String contentid) throws Exception;
	AttrLikeDto isLike(AttrLikeDto attrLikeDto) throws Exception;
	int likeAttr(AttrLikeDto attrLikeDto) throws Exception;
	int insertLike(AttrLikeDto attrLikeDto) throws Exception;
	List<AttrDto> likeList(String userId) throws Exception;
	List<AttrDto> search(String searchWord) throws Exception;
	List<AttrDto> getHotPlace() throws Exception;
	List<AttrDto> getHotPlaceByCate(String sido, String gugun, String cate) throws Exception;
}
