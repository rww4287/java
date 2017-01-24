package com.ktds.kjj;

public class Calculator {
	
	public void printComputeResult(){
		int result =1 +1 ;
		System.out.println(result);
	}
	/*
	 * printComputeResult method over loading
	 * 메소드의 이름은 같지만 파라미터의 종류나 개수가 다른 메소드
	 */
	public void printComputeResult(int numberOne,int numberTwo){
		int result = numberOne + numberTwo;
		System.out.println(result);
	}
	
	/**
	 * 숫자 두 개를 전달 받아 곱한 뒤 출력하고 반환한다. 
	 *  
	 * @param numberOne : int 첫 번째 숫자 
	 * @param numberTwo : int 두 번째 숫자
	 * @return : int numberOne * numberTwo
	 */
	public int getAndPrintMultiplicationResult(int numberOne, int numberTwo){
		int result = numberOne * numberTwo;

		
		return result;
	}

}
