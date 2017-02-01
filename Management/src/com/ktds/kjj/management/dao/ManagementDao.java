package com.ktds.kjj.management.dao;

import java.util.List;

import com.ktds.kjj.management.vo.InformationVO;

public interface ManagementDao {
	
	/**
	 * 1. 전체 직원 조회하기
	2. 직원 추가 (입사)
	3. 직원 삭제 (퇴사)
	4. 직원 수정 (진급)
	5. 프로그램 종료
	 * 
	 */
	
	public List<InformationVO> queryAllList();
	
	public void addMember (InformationVO information);
	public void removerMember (int index);
	public void updateMember (int index, InformationVO information);

}
