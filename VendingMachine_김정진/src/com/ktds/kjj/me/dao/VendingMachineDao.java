package com.ktds.kjj.me.dao;

import com.ktds.kjj.me.vo.StockVO;

public interface VendingMachineDao {

	public void chooseCoke();
	public void chooseFanta();
	public void chooseSprite();
	
	public void setHavingMoney(int inputMoney);
	public void insertMoney(int insertMoney);
	
	public void returnMoney(int insertMoney);
}
