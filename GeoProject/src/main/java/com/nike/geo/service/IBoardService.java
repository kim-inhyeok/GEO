package com.nike.geo.service;

import java.util.List;
import java.util.Map;


import com.nike.geo.vo.bo.BoardVo;
import com.nike.geo.vo.bo.LikeVo;


public interface IBoardService {
	
	public List<BoardVo> announcements();
	
	public List<BoardVo> nomalBoard();
	
	public List<BoardVo> delBoard();
	
	public boolean insertBoard(BoardVo Vo);
	
	public BoardVo detailBoard(String bo_no);
	
	public boolean modifyBoard(Map<String, String> map);
	
	public boolean multiDeleteBoard(List<String>list);
	
	public boolean realDelete(List<String> list);

	public BoardVo view_Count(BoardVo bVo);
	//추천
	public BoardVo likeCount(BoardVo vo);

}
