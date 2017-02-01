package com.ktds.kjj.address.biz;

import java.util.List;

import com.ktds.kjj.address.book.vo.AddressVO;
public interface AddressBiz {

	/**
	 	System.out.println("1. 주소록 조회");
		System.out.println("2. 주소 검색");
		System.out.println("3. 주소 삭제");
		System.out.println("4. 주소 수정");
		System.out.println("5. 주소 추가");
	 */
	
	/**
	 * 주소록 조회
	 * @return 모든 주소를 반환함
	 */
	public void queryAllList();

	/**
	 * 주소검색
	 * @param index 주소번호 ( 1, 2, 3, 4 ..)
	 * @return 하나의 주소를 반환함
	 */
	public void findOneAddress();
	
	/**
	 * 주소 삭제
	 * @param index 삭제할 주소번호( 1, 2, 3, 4...)
	 */
	public void removerAddress();
	
	/**
	 * 주소 수정
	 * @param index 수정할 주소번호 (1, 2, 3, 4 ..)
	 * @param newAddress 신규 주소 정보
	 */
	public void updateAddress();
	
	/**
	 * 주소 추가
	 * @param newAddress 신규 주소 정보
	 */
	public void addAddress();
}
