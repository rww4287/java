package com.ktds.kjj.coffee;

public class Cafe2 {
	
	public static void main(String[] args) {
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		//서브 클래스가 슈퍼클래스에 할당이 된다. 
		CoffeeMachine latteMachine = new LatteMachine();
		
		
		
		Barista barista = new Barista();
		barista.coffee(coffeeMachine);
		barista.coffee(latteMachine);
		
	}

}
