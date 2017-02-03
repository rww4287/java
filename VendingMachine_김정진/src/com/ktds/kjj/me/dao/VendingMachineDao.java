package com.ktds.kjj.me.dao;

import com.ktds.kjj.me.vo.VendingMachineVO;

public interface VendingMachineDao {

	public void chooseDrink(int index);
	public void chooseCoke();
	public void chooseFanta();
	public void chooseSprite();
	
	public void setHavingMoeny(int inputMoney);
	public void insertMoney(int insertMoney);
	
	public void returnMoney(int insertMoney);
}
