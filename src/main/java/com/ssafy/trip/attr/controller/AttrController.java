package com.ssafy.trip.attr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.trip.attr.model.AttrDto;
import com.ssafy.trip.attr.model.AttrLikeDto;
import com.ssafy.trip.attr.model.CategoryDto;
import com.ssafy.trip.attr.model.GugunDto;
import com.ssafy.trip.attr.model.SidoDto;
import com.ssafy.trip.attr.model.service.AttrService;
import com.ssafy.trip.board.controller.BoardController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/attr")
@Api("어트렉션 컨트롤러 API V1")
public class AttrController {

    private final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private AttrService as;

    @ApiOperation(value = "시도 코드 반환.", response = List.class)
    @GetMapping("/sido")
    public ResponseEntity<?> getSido() {
        logger.info("getSido - 호출 : ()");
        try {
            List<SidoDto> data = as.getSido();
            if (data != null && data.size() > 0)
                return new ResponseEntity<List<SidoDto>>(data, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "구군 코드 반환.", response = List.class)
    @GetMapping("/gugun")
    public ResponseEntity<?> getGugun(@RequestParam("sido") @ApiParam(value = "시도코드.", required = true) String sido) {
        logger.info("getGugun - 호출 : " + sido);
        try {
            List<GugunDto> data = as.getGugun(sido);
            if (data != null && data.size() > 0)
                return new ResponseEntity<List<GugunDto>>(data, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "카테고리 코드 반환.", response = List.class)
    @GetMapping("/category")
    public ResponseEntity<?> getCate() {
        logger.info("getCate - 호출 : ()");
        try {
            List<CategoryDto> data = as.getCate();
            if (data != null && data.size() > 0)
                return new ResponseEntity<List<CategoryDto>>(data, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "핫플레이스 확인", notes = "핫플레이스 불러오기 ")
    @GetMapping("hotplace")
    public ResponseEntity<?> hotplace(){
    	
    	try {
    		List<AttrDto> data = as.getHotPlace();
    		return new ResponseEntity<List<AttrDto>>(data, HttpStatus.OK);
    	} catch(Exception e) {
    		return exceptionHandling(e);
    	}
    }
    
    @ApiOperation(value = "지역별 핫플레이스 확인", notes = "지역별 핫플레이스 불러오기 ")
    @GetMapping("hotplacebycate")
    public ResponseEntity<?> hotplacebyCate(String sido, String gugun,String cate){
    	
    	try {
    		List<AttrDto> data = as.getHotPlaceByCate(sido, gugun, cate);
    		return new ResponseEntity<List<AttrDto>>(data, HttpStatus.OK);
    	} catch(Exception e) {
    		return exceptionHandling(e);
    	}
    }
    
    @ApiOperation(value = "관광지 문자 검색", notes = "검색 해서 관광지 리스트 조회")
    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam("searchword") String searchWord) {
    	try {
    		List<AttrDto> data = as.search(searchWord);
    		return new ResponseEntity<List<AttrDto>>(data, HttpStatus.OK);
    	} catch (Exception e) {
    		return exceptionHandling(e);
    	}
    }
    
    @ApiOperation(value = "관광지 검색", response = List.class)
    @GetMapping("/attrSearch")
    public ResponseEntity<?> attrSearch(@RequestParam("sido") String sido,@RequestParam("gugun") String gugun,@RequestParam("cate") String cate) {
        logger.info("attrSearch - 호출 : ()");
        try {
            List<AttrDto> data = as.byCategory(sido, gugun, cate);
            System.out.println(data.get(0).toString());
            if (data != null && data.size() > 0)
                return new ResponseEntity<List<AttrDto>>(data, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    @ApiOperation(value = "상세내용 검색", response = List.class)
    @GetMapping("/desc")
    public ResponseEntity<?> findDesc(@RequestParam("contentid") String contentid) {
        logger.info("attrSearch - 호출 : ()");
        try {
            String data = as.findDesc(contentid);
            if (data != null && data.length() > 0)
                return new ResponseEntity<String>(data, HttpStatus.OK);
            else
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    
    
    
    @ApiOperation(value = "관광지 좋아요 확인", notes = "관광지 좋아요 확인")
    @GetMapping("/islike")
    public ResponseEntity<?> isLike(@RequestParam("userid") String userId, @RequestParam("contentid")String contentId){
        AttrLikeDto attrLikeDto = new AttrLikeDto();
        attrLikeDto.setContentId(contentId);
        attrLikeDto.setUserId(userId);
        try {
            AttrLikeDto result = as.isLike(attrLikeDto);
            if(result != null) {
                attrLikeDto.setValue(result.getValue());
            }
            
        } catch(Exception e) {
            return exceptionHandling(e);
        }
        
        return new ResponseEntity<AttrLikeDto>(attrLikeDto, HttpStatus.OK);
    }

    @ApiOperation(value = "관광지 좋아요", notes = "관광지 좋아요 토글")
    @GetMapping("/like")
    public ResponseEntity<?> likeAttr(@RequestParam("userid") String userId, @RequestParam("contentid") String contentId) {
        AttrLikeDto attrLikeDto = new AttrLikeDto();
        attrLikeDto.setUserId(userId);
        attrLikeDto.setContentId(contentId);
        
        try {
            
            if(as.isLike(attrLikeDto) == null) { // 한번도 좋아요 하지 않은 경우
                 if(as.insertLike(attrLikeDto) > 0) {
                     logger.debug("좋아요 넣기 성공!");
                     attrLikeDto.setValue(as.isLike(attrLikeDto).getValue());
                     return new ResponseEntity<AttrLikeDto>(attrLikeDto, HttpStatus.OK);
                 }
                 
            } else { // 누른 적 있는 경우
                logger.debug("누른적 있습니다.");
                if(as.likeAttr(attrLikeDto) > 0) {
                    logger.debug("toggle 성공!!");
                    attrLikeDto.setValue(as.isLike(attrLikeDto).getValue());
                    return new ResponseEntity<AttrLikeDto>(attrLikeDto, HttpStatus.OK);
                }
            }
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }
    
    @GetMapping("/likelist")
    @ApiOperation(value = "좋아요 리스트", notes = "사용자가 좋아요 누른 리스트 불러오기")
    public ResponseEntity<?> likeList(@RequestParam("userid") String userId){
    	try {
    		List<AttrDto> attrList = as.likeList(userId);
    		
    		return new ResponseEntity<List<AttrDto>>(attrList, HttpStatus.OK);
    		
    	} catch (Exception e){
    		
    		return exceptionHandling(e);
    	}
    	
    }

    private ResponseEntity<String> exceptionHandling(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}