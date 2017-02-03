package com.ktds.kjj.me.biz;

public interface VendingMachineBiz {
	
	public void operator();
	
	public void chooseCoke();
	public void chooseSprite();
	public void chooseFanta();
	
	public void setHavingMoney();
	public void returnMoney(int insertMoney);
	public void showAndChoose(int insertMoney);

}
