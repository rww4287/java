package com.ktds.kjj.me.dao;

import com.ktds.kjj.me.vo.MoneyVO;
import com.ktds.kjj.me.vo.StockVO;

public class VendingMachineDaoImpl implements VendingMachineDao {

	MoneyVO moneyVO;
	StockVO stockVO;

	public VendingMachineDaoImpl() {
		moneyVO = new MoneyVO();
		stockVO = new StockVO();

		stockVO.setStockOfCoke(5);
		stockVO.setStockOfFanta(4);
		stockVO.setStockOfSprite(3);
	}

	@Override
	public void chooseCoke() {
		stockVO.setStockOfCoke((stockVO.getStockOfCoke() - 1));
		stockVO.setStockOfCoke((stockVO.getStockOfCoke() + 1));
	}

	@Override
	public void chooseFanta() {
		stockVO.setStockOfFanta((stockVO.getStockOfFanta() - 1));
		stockVO.setStockOfFanta((stockVO.getStockOfFanta() + 1));

	}

	@Override
	public void chooseSprite() {
		stockVO.setStockOfSprite((stockVO.getStockOfSprite() - 1));
		stockVO.setStockOfSprite((stockVO.getStockOfSprite() + 1));
	}

	@Override
	public void setHavingMoney(int inputMoney) {
		moneyVO.setMoneyOfPerson(inputMoney);
		moneyVO.setMoneyOfMachine(500000);
	}

	@Override
	public void insertMoney(int insertMoney) {
		moneyVO.setInsertMoney(insertMoney);
		moneyVO.setMoneyOfMachine((moneyVO.getMoneyOfMachine() + insertMoney));
		moneyVO.setMoneyOfPerson((moneyVO.getMoneyOfPerson() - insertMoney));
	}

	@Override
	public void returnMoney(int insertMoney) {
		moneyVO.setMoneyOfPerson((moneyVO.getMoneyOfPerson() + insertMoney));
		moneyVO.setMoneyOfMachine((moneyVO.getMoneyOfMachine() - insertMoney));
	}

}
