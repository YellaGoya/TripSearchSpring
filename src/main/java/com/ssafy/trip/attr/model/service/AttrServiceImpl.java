package com.ssafy.trip.attr.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.trip.attr.model.AttrDto;
import com.ssafy.trip.attr.model.AttrLikeDto;
import com.ssafy.trip.attr.model.CategoryDto;
import com.ssafy.trip.attr.model.GugunDto;
import com.ssafy.trip.attr.model.SidoDto;
import com.ssafy.trip.attr.model.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SidoDto> getSido() throws Exception {
		return sqlSession.getMapper(AttrMapper.class).getSido();
	}

	@Override
	public List<GugunDto> getGugun(String sido) throws Exception {
		return sqlSession.getMapper(AttrMapper.class).getGugun(sido);
	}
	
	@Override
	public List<CategoryDto> getCate() throws Exception {
		return sqlSession.getMapper(AttrMapper.class).getCate();
	}

	@Override
	public List<AttrDto> byCategory(String sido, String gugun, String cate) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sidoCode", sido);
		param.put("cateCode", cate);
		param.put("gugunCode", gugun);
		return sqlSession.getMapper(AttrMapper.class).byCategory_gugun(param);
	}
	
	@Override
	public String findDesc(String contentid) throws Exception{
		return sqlSession.getMapper(AttrMapper.class).findDesc(contentid);
	}

	@Override
	public AttrLikeDto isLike(AttrLikeDto attrLikeDto) throws Exception {
		return sqlSession.getMapper(AttrMapper.class).isLike(attrLikeDto);
	}

	@Override
	public int likeAttr(AttrLikeDto attrLikeDto) throws Exception {
		return sqlSession.getMapper(AttrMapper.class).likeAttr(attrLikeDto);
	}

	@Override
	public int insertLike(AttrLikeDto attrLikeDto) throws Exception {
		return sqlSession.getMapper(AttrMapper.class).insertLike(attrLikeDto);
	}

	@Override
	public List<AttrDto> likeList(String userId) throws Exception {
		return sqlSession.getMapper(AttrMapper.class).likeList(userId);
	}

	@Override
	public List<AttrDto> getHotPlace() throws Exception {
		return sqlSession.getMapper(AttrMapper.class).getHotPlace();
	}

	@Override
	public List<AttrDto> getHotPlaceByCate(String sido, String gugun, String cate) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sidoCode", sido);
		map.put("gugunCode", gugun);
		map.put("cateCode", cate);
		return sqlSession.getMapper(AttrMapper.class).getHotPlaceByCate(map);
	}

	@Override
	public List<AttrDto> search(String searchWord) throws Exception {
		return sqlSession.getMapper(AttrMapper.class).search(searchWord);
	}
	
}
