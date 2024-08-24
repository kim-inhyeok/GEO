package com.nike.geo.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nike.geo.service.IMsgService;

import lombok.extern.slf4j.Slf4j;

//ajax 사용 컨트롤러
@Slf4j
@RestController
public class MsgRestController {
	
	@Autowired
	private IMsgService service;

	@PostMapping(value = "/deleteMsgRecv.do")
	public String deleteMsgRecv(@RequestParam List<String> msg_no) {
		log.info("MESSAGE controller - 받은 쪽지 삭제");
		log.info("MESSAGE controller - msg_no의 값 : {}", msg_no);
		int deleteNum = service.deleteMsgRecv(msg_no);
		log.info("MESSAGE controller - 삭제된 쪽지 갯수 : {}", deleteNum);
		return (deleteNum>0)?"true":"false";
	}
	
	@PostMapping(value = "/deleteMsgSend.do")
	public String deleteMsgSend(@RequestParam List<String> msg_no) {
		log.info("MESSAGE controller - 보낸 쪽지 삭제");
		log.info("MESSAGE controller - msg_no의 값 : {}", msg_no);
		int deleteNum = service.deleteMsgSend(msg_no);
		log.info("MESSAGE controller - 삭제된 쪽지 갯수 : {}", deleteNum);
		return (deleteNum>0)?"true":"false";
	}
}
