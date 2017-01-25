package com.ktds.kjj;

public class Car {
	
	private String modelName;
	private int oilTankVolume;
	private int money;
	private int oilStock;

	public Car(String modelName, int oilTankVolume, int money) {
		this.modelName = modelName;
		this.oilTankVolume = oilTankVolume;
		this.money = money;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getOilTankVolume() {
		return oilTankVolume;
	}

	public void setOilTankVolume(int oilTankVolume) {
		this.oilTankVolume = oilTankVolume;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public int getOilStock() {
		return oilStock;
	}
	
	public void setOilStock(int oilStock) {
		this.oilStock = oilStock;
	}
	
	public void fillOil(OilBank oilBank) {
		oilStock = this.oilTankVolume;
		this.money -= (this.oilTankVolume * oilBank.getPricePerLiter());
	}
	

}
