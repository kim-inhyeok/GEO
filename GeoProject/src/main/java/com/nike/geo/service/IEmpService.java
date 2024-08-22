package com.nike.geo.service;

import java.util.List;
import java.util.Map;

import com.nike.geo.vo.hr.EmpVo;

public interface IEmpService {
	
	// 사원 추가
	public int insertEmp(EmpVo vo);
	
	// 사원 전체 목록
	public List<EmpVo> selectAll();
	
	// 사원 상세 정보
	public EmpVo selectOneEmp(String emp_no);
	
	// 사원 정보 변경
	public int updateEmp(EmpVo vo);
	
	// 비밀번호 변경
	public int modPw(EmpVo vo);
	

}
