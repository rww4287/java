package com.ktds.kjj.management;

import java.util.Scanner;

import com.ktds.kjj.management.biz.InformationBiz;
import com.ktds.kjj.management.biz.InformationBizImpl;

public class MainController {
	
	public void start(){
		/**
		 * 
			1. 전체 직원 조회하기
			2. 직원 추가 (입사)
			3. 직원 삭제 (퇴사)
			4. 직원 수정 (진급)
			5. 프로그램 종료
		 */
		int choose = 0;
		Scanner input = new Scanner(System.in);
		InformationBiz informationBiz = new InformationBizImpl();
		
		while( true ){
			System.out.println("======== 직원 관리프로그램 =====");
			System.out.println("1. 전체 직원 조회하기");
			System.out.println("2. 직원 추가(입사)");
			System.out.println("3. 직원 삭제(퇴사)");
			System.out.println("4. 직원 수정(진급)");
			System.out.println("5. 프로그램 종료");
			System.out.println("=============================");
			choose = input.nextInt();
			if ( choose == 1 ){
				informationBiz.queryAllList();
			}
			else if ( choose == 2 ){
				informationBiz.addMember();
			}
			else if ( choose == 3 ){
				informationBiz.removerMember();
			}
			else if ( choose == 4 ){
				informationBiz.updateMember();
			}
			else {
				break; 
			}
		}
	}
	
	public static void main(String[] args) {
		new MainController().start();
	}

}
