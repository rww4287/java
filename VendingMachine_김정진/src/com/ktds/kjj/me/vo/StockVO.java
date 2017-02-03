package com.ktds.kjj.me.vo;

public class StockVO {

	private int stockOfCoke;
	private int stockOfFanta;
	private int stockOfSprite;

	private int stockOfTotal = 0;

	public int getStockOfTotal() {
		return stockOfTotal;
	}

	public void setStockOfTotal(int stockOfTotal) {
		this.stockOfTotal = stockOfCoke + stockOfFanta + stockOfSprite;
	}

	public int getStockOfCoke() {
		return stockOfCoke;
	}

	public void setStockOfCoke(int stockOfCoke) {
		this.stockOfCoke = stockOfCoke;
	}

	public int getStockOfFanta() {
		return stockOfFanta;
	}

	public void setStockOfFanta(int stockOfFanta) {
		this.stockOfFanta = stockOfFanta;
	}

	public int getStockOfSprite() {
		return stockOfSprite;
	}

	public void setStockOfSprite(int stockOfSprite) {
		this.stockOfSprite = stockOfSprite;
	}

}
