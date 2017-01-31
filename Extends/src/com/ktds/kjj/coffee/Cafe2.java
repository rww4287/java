package com.ktds.kjj.coffee;

public class Cafe2 {
	
	public static void main(String[] args) {
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		CoffeeMachine latteMachine = new LatteMachine();
		
		
		Barista barista = new Barista();
		barista.coffee(coffeeMachine);
		barista.coffee(latteMachine);
		
	}

}
