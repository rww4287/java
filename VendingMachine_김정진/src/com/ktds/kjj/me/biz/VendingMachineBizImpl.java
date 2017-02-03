package com.ktds.kjj.me.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.kjj.me.dao.VendingMachineDao;
import com.ktds.kjj.me.vo.VendingMachineVO;

import static com.ktds.kjj.me.PriceVO.*;

import java.util.Scanner;

public class VendingMachineBizImpl implements VendingMachineBiz {

	VendingMachineDao vendingMachineDao;

	Scanner input = new Scanner(System.in);

	public VendingMachineBizImpl() {

	}

	@Override
	public void chooseCoke() {

	}

	@Override
	public void chooseSprite() {
		// TODO Auto-generated method stub

	}

	@Override
	public void chooseFanta() {
		// TODO Auto-generated method stub

	}

	public void setHavingMoney() {
		System.out.print("보유할 금액을 입력하세요.");
		int havingMoney = input.nextInt();
		vendingMachineDao.setHavingMoeny(havingMoney);
	}

	@Override
	public void insertMoney() {
		System.out.println("투입할 금액을 입력하세요.");
		int isertMoney = input.nextInt();
		vendingMachineDao.insertMoney(isertMoney);
	}

	private void showBuyableDrink(int insertMoney) {
		if (insertMoney < SPRITE) {
			System.out.println("잔액이 부족합니다.");
			insertMoney();
		} else if (insertMoney >= SPRITE && insertMoney < COKE) {
			showDrinkList(insertMoney);
		}
	}

	public void showDrinkList(int insertMoney) {
		if (insertMoney < SPRITE) {
			returnMoney(insertMoney);
		} else if (insertMoney >= SPRITE && insertMoney < COKE) {
			// sprite
		} else if (insertMoney >= COKE && insertMoney < FANTA) {
			// sprite & coke
		} else {
			// sprite & coke & fanta
		}
	}

	@Override
	public void returnMoney(int insertMoney) {
		vendingMachineDao.returnMoney(insertMoney);
	}

}
