package com.nike.geo.model;

import java.util.List;

import com.nike.geo.vo.msg.MsgVo;

public interface IMsgDao {
	
	// 받은 쪽지 목록 조회 selectMsgListRecv
	public List<MsgVo> selectMsgListRecv(String recvId);
	
	// 보낸 쪽지 목록 조회 selectMsgListSend
	public List<MsgVo> selectMsgListSend(String sendId);
	
	// 쪽지 상세 조회 selectMsgOne
	public MsgVo selectMsgOne(String no);
	
	// 쪽지 작성 insertMsg
	public int insertMsg(MsgVo vo);
	
	// 쪽지 읽기 updateMsgRead
	public int updateMsgRead(MsgVo vo);
	
	// 받은 쪽지 삭제(update) deleteMsgRecv
	public int deleteMsgRecv(List<String> noList);
}
