package com.ktds.kjj.me.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.kjj.me.vo.MoneyVO;
import com.ktds.kjj.me.vo.ProductVO;
import com.ktds.kjj.me.vo.VendingMachineVO;

public class VendingMachineDaoImpl implements VendingMachineDao {

	MoneyVO moneyVO;

	List<ProductVO> productListOfPerson ;
	List<ProductVO> productListOfMachine;

	public VendingMachineDaoImpl() {
		
	}

	@Override
	public void chooseCoke() {

	}

	@Override
	public void chooseFanta() {
		// TODO Auto-generated method stub

	}

	@Override
	public void chooseSprite() {
		// TODO Auto-generated method stub

	}

	@Override
	public void chooseDrink(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHavingMoeny(int inputMoney) {
		moneyVO.setMoneyOfPerson(inputMoney);
		moneyVO.setMoneyOfMachine(500000);
	}

	@Override
	public void insertMoney(int insertMoney) {
		moneyVO.setInsertMoney(insertMoney);
		moneyVO.setMoneyOfMachine(moneyVO.getMoneyOfMachine() + insertMoney);
		moneyVO.setMoneyOfPerson(moneyVO.getMoneyOfPerson() - insertMoney);
	}

	@Override
	public void returnMoney(int insertMoney) {
		moneyVO.setMoneyOfPerson(moneyVO.getMoneyOfPerson() + insertMoney);
		moneyVO.setMoneyOfMachine(moneyVO.getMoneyOfMachine() - insertMoney);
	}

}
