package com.ktds.kjj;

public class RentalShop {
	
	private int bycleStock = 100;
	private int fee;
	private final int RENTAL_FEE = 5000; 
	
	
	public RentalShop(int fee){
		this.fee = fee;
	}
	
	public void setBycleStock(int bycleStock) {
		this.bycleStock = bycleStock;
	}
	
	public int getBycleStock() {
		return bycleStock;
	}
	
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	public int getFee() {
		return fee;
	}
	
	public int getRENTAL_FEE() {
		return RENTAL_FEE;
	}

	public void loan(User user){
		this.bycleStock -= user.getRentBycle();
		this.fee += (user.getRentBycle() * RENTAL_FEE);
	}

}
