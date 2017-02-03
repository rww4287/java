package com.ktds.kjj.me.biz;

public interface VendingMachineBiz {
	
	public void chooseCoke();
	public void chooseSprite();
	public void chooseFanta();
	
	public void setHavingMoney();
	public void insertMoney();
	
	public void returnMoney(int insertMoney);

}
