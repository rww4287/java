package com.ktds.kjj;

public class Cafe2 {
	
	public static void main(String[] args) {
		
		CoffeeMachine coffeeMachine = new EspressoMachine();
		CoffeeMachine latteMachine = new LatteMachine();
		CoffeeMachine chocoLatteMachine = new ChocoLatteMachine();
		
		Barista barista = new Barista();
		barista.coffee(coffeeMachine);
		System.out.println("=============");
		barista.coffee(latteMachine);
		System.out.println("=============");
		barista.coffee(chocoLatteMachine);
	}

}
