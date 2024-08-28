package com.nike.geo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nike.geo.model.IBoardDao;
import com.nike.geo.vo.bo.BoardVo;
import com.nike.geo.vo.bo.LikeVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements IBoardService {

	@Autowired
	private final IBoardDao dao;
	
	@Override
	public List<BoardVo> announcements() {
		
		return dao.announcements();
	}
	
	@Override
	public List<BoardVo> nomalBoard() {
		
		return dao.nomalBoard();
	}
	
	@Override
	public List<BoardVo> delBoard() {
	
		return dao.delBoard();
	}
	
	@Override
	public boolean insertBoard(BoardVo Vo) {
		
		return dao.insertBoard(Vo);
	}
	
	@Override
	public BoardVo detailBoard(String bo_no) {
		System.out.println("브이오엔오"+bo_no);
		return dao.detailBoard(bo_no);
	}
	
	@Override
	public boolean modifyBoard(Map<String, String> map) {
		return dao.modifyBoard(map);
	}
	
	@Override
	public boolean multiDeleteBoard(List<String> list) {
		
		return dao.multiDeleteBoard(list);
	}
	
	@Override
	public boolean realDelete(List<String> list) {
		return dao.realDelete(list);
	}

	@Override
	public BoardVo view_Count(BoardVo bVo) {
		Map<String, String> map = new HashMap<String, String>(){{
			put("bo_no", bVo.getBo_no()); 
			put("emp_no", bVo.getEmp_no());
			}};
		int cnt = dao.searchBoardOne(map);
		System.out.println(cnt>0?"읽은 사람": "아닌 사람");
		if(cnt==0) {
			dao.insertReadOne(map);
		}else {
			
		}
		BoardVo resultVo =  dao.selectOne(bVo.getBo_no());
		System.out.println("상세글 조회" +resultVo);
		
		return resultVo;
	}
	//추천
	@Override
	public BoardVo likeCount(BoardVo vo) {
		BoardVo resultVo = dao.selectOne(vo.getBo_no());
		Map<String, String>map = new HashMap<String, String>(){{
			put("bo_no", vo.getBo_no());
			put("emp_no",vo.getEmp_no());
		}};
		boolean up = dao.likeUpdate(map);
		if(!up) {
			dao.likeInsert(map);
	}
		return resultVo;
			
	}
}


















