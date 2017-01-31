package com.ktds.kjj;

public abstract class CoffeeMachine { //abstract가 붙어있는 추상클래스는 인스턴스화 할수 없다. 
	
	protected int atm = 9;
	
	public void espresso(){ //공통으로 실행 할수 있는 메소드 
		System.out.println(atm + " 기압으로 에스프레소를 추출합니다.");
	}
	
	public abstract void latte(); 

}
