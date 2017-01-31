package com.ktds.kjj.coffee;

public class LatteMachine extends CoffeeMachine {
	
	// private int atm;
	
	public LatteMachine(){
		// atm = 15; 
		super.atm = 15;
	}
	
	@Override // 재정의 (녹색 삼각형)
	public void latte(){
		System.out.println(super.atm + " 기압으로 카페라떼를 추출합니다.");
		
	}

}
