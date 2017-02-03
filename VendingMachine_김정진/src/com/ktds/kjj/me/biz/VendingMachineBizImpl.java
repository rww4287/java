package com.ktds.kjj.me.biz;

import static com.ktds.kjj.me.PriceConsts.COKE;
import static com.ktds.kjj.me.PriceConsts.FANTA;
import static com.ktds.kjj.me.PriceConsts.SPRITE;

import java.util.Scanner;

import com.ktds.kjj.me.dao.VendingMachineDao;
import com.ktds.kjj.me.dao.VendingMachineDaoImpl;
import com.ktds.kjj.me.vo.MoneyVO;
import com.ktds.kjj.me.vo.StockVO;

public class VendingMachineBizImpl implements VendingMachineBiz {

	VendingMachineDao vendingMachineDao;

	MoneyVO moneyVO;
	StockVO stockVO;

	Scanner input = new Scanner(System.in);
	int choose = 0;

	public VendingMachineBizImpl() {
		vendingMachineDao = new VendingMachineDaoImpl();
	}

	@Override
	public void operator() {
		System.out.println("Welcome VendingMachine!!~!~!");
		setHavingMoney();
		System.out.println("투입할 금액을 입력하세요.");
		int insertMoney = input.nextInt();
		showAndChoose(insertMoney);

	}

	public void setHavingMoney() {
		System.out.print("보유할 금액을 입력하세요.");
		int havingMoney = input.nextInt();
		vendingMachineDao.setHavingMoney(havingMoney);
		System.out.println("clear setHavingMoney");
	}

	public void showAndChoose(int insertMoney) {
		
	//	int tempMoney = moneyVO.getMoneyOfPerson();
	//	int tempStock = stockVO.getStockOfTotal();
		
		while (true) {
			if (insertMoney < SPRITE) {
				returnMoney(insertMoney);
			} else if (insertMoney >= SPRITE && insertMoney < COKE) {
				System.out.printf("3. Sprite (사이다)\n 선택하세요 : ");
				choose = input.nextInt();
				if (choose == 3) {
					chooseSprite();
					System.out.println(stockVO.getStockOfTotal());
					System.out.println(moneyVO.getMoneyOfPerson());
				}
			} else if (insertMoney >= COKE && insertMoney < FANTA) {
				System.out.printf("1. Coke (콜라)\n 3.S prite(사이다)\n선택하세요 : ");
				choose = input.nextInt();
				if (choose == 1) {
					chooseCoke();
				} else if (choose == 3) {
					chooseSprite();
				}
			} else {
				System.out.print("1. Coke(콜라)\n2. Fanta(환타)\n3. Sprite(사이다) \n선택하세요: ");
				choose = input.nextInt();
				if (choose == 1) {
					chooseCoke();
				} else if (choose == 2) {
					chooseFanta();
				} else if (choose == 3) {
					chooseSprite();
				}
			}
		}
	}

	@Override
	public void chooseCoke() {
		vendingMachineDao.chooseCoke();
	}

	@Override
	public void chooseSprite() {
		vendingMachineDao.chooseSprite();
	}

	@Override
	public void chooseFanta() {
		vendingMachineDao.chooseFanta();

	}

	@Override
	public void returnMoney(int insertMoney) {
		vendingMachineDao.returnMoney(insertMoney);
	}

}
