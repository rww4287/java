package com.ktds.kjj;

public class LatteMachine extends CoffeeMachine {

	public LatteMachine(){
		super.atm = 15;
	}
	@Override
	public void latte() {
		System.out.println(atm + " 기압으로 라떼를 추출합니다.");
		
	}

}
