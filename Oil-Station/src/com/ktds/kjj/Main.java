package com.ktds.kjj;

public class Main {
	
	public static void main(String[] args) {
		
		OilBank oilBank = new OilBank();
		oilBank.setOilStock(5000);
		oilBank.setPricePerLiter(1480);
		oilBank.setBudget(0);
		
		Car car = new Car("무쏘",50,10000000);
		
		oilBank.filling(car);
		
		System.out.println("=====주유소=====");
		System.out.println(oilBank.getOilStock());
		System.out.println(oilBank.getBudget());
		
		System.out.println("=====자동차=====");
		System.out.println(car.getModelName());
		System.out.println(car.getOilTankVolume());
		System.out.println(car.getOilStock());
		System.out.println(car.getMoney());
		
	}

}
