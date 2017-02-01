package com.ktds.kjj.management.biz;

public interface InformationBiz {
	
	/**
	 * 1. 전체 직원 조회하기
	2. 직원 추가 (입사)
	3. 직원 삭제 (퇴사)
	4. 직원 수정 (진급)
	5. 프로그램 종료
	 * 
	 */
	
	public void queryAllList();
	public void addMember();
	public void removerMember();
	public void updateMember();

}
