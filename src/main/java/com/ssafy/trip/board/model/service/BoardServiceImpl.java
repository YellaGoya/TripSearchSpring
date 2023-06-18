package com.ssafy.trip.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.ssafy.trip.board.model.BoardDto;
import com.ssafy.trip.board.model.BoardParamDto;
import com.ssafy.trip.board.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper boardMapper;
	
	
	@Autowired
	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public int write(BoardDto boardDto) throws Exception {
		return boardMapper.write(boardDto);
	}
	
	@Override
    public int writeWithConId(BoardDto boardDto) throws Exception {
        return boardMapper.writeWithConId(boardDto);
    }
	

	@Override
	public List<BoardDto> listBoard(BoardParamDto boardParam) throws Exception {
//		Map<String, Object> param = new HashMap<String, Object>();
//		String key = map.get("key");
//		if("userid".equals(key)) {
//			key = "user_id";
//		}
//		param.put("key", key == null ? "" : key);
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
//		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
//		param.put("start", start);
//		param.put("listsize", SizeConstant.LIST_SIZE);
		int start = boardParam.getPg() == 0 ? 0 : (boardParam.getPg() - 1) * boardParam.getSpp();
		boardParam.setStart(start);
		return boardMapper.listBoard(boardParam);
	}
	
	@Override
	public int getTotalArticle(BoardParamDto boardParam) throws Exception {
		// TODO Auto-generated method stub
		int start = boardParam.getPg() == 0 ? 0 : (boardParam.getPg() - 1) * boardParam.getSpp();
		boardParam.setStart(start);
		return boardMapper.getTotalArticleCount(boardParam);
	}
	
//	@Override
//	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
//		PageNavigation pageNavigation = new PageNavigation();
//
//		int naviSize = SizeConstant.NAVIGATION_SIZE;
//		int sizePerPage = SizeConstant.LIST_SIZE;
//		int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
//
//		pageNavigation.setCurrentPage(currentPage);
//		pageNavigation.setNaviSize(naviSize);
//		Map<String, Object> param = new HashMap<String, Object>();
//		String key = map.get("key");
//		if ("userid".equals(key))
//			key = "user_id";
//		param.put("key", key == null ? "" : key);
//		param.put("word", map.get("word") == null ? "" : map.get("word"));
//		int totalCount = boardMapper.getTotalArticleCount(param);
//		pageNavigation.setTotalCount(totalCount);
//		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
//		pageNavigation.setTotalPageCount(totalPageCount);
//		boolean startRange = currentPage <= naviSize;
//		pageNavigation.setStartRange(startRange);
//		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
//		pageNavigation.setEndRange(endRange);
//		pageNavigation.makeNavigator();
//
//		return pageNavigation;
//	}

	@Override
	public BoardDto detail(String articleNo) throws Exception {
		return boardMapper.detail(articleNo);
	}
	
	
	@Override
	public void updateHit(int articleNo) throws Exception {
		boardMapper.updateHit(articleNo);	
	}

	@Override
	public int delete(String articleNo) throws Exception {
		return boardMapper.delete(articleNo);
	}

	@Override
	public int modify(BoardDto boardDto) throws Exception {
		return boardMapper.modify(boardDto);
	}

	@Override
	public int like(BoardDto boardDto) throws Exception {
		try{
			boardMapper.likeVisited(boardDto);
			
		} catch(DuplicateKeyException e) {
			return 0;
		}
		
		return boardMapper.updateLike(boardDto.getArticleNo());
	}

	
	
	
	
	
	
//	@Override
//	public int hotplaceRegister(HotPlaceDto hotplaceDto) throws Exception {
//		return boardDao.hotplaceRegister(hotplaceDto);
//	}
	
}
