package com.ktds.kjj.coffee;

public class Cafe {
	
	public static void main(String[] args) {
		
		CoffeeMachine espressoMachine = new CoffeeMachine();
		espressoMachine.espresso();
		
		//Sub class is a Super class
		System.out.println("============= 라떼 머신 =============");
		
		CoffeeMachine latteMachine = new LatteMachine();
		LatteMachine latte = (LatteMachine) latteMachine;
		
		//CoffeeMachine 타입에는 latte()가 없기때문에 error가 난다. casting을 해줘야함 
		((LatteMachine) latteMachine).latte(); 
		latteMachine.espresso();
		
		System.out.println(espressoMachine);
		System.out.println(latteMachine);
	}

}
