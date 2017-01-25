package com.ktds.kjj;

import java.util.Scanner;

public class User {
	
	private int money;
	// 현재 보유하고 있는 자전거 수
	private int bycleStock;
	// 빌리고싶은 자전거 수
	private int rentBycle; 
	
	public User(int money, int rentBycle){
		this.money = money;
		this.rentBycle = rentBycle;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBycleStock() {
		return bycleStock;
	}

	public void setBycleStock(int bycleStock) {
		this.bycleStock = bycleStock;
	}

	public int getRentBycle() {
		return rentBycle;
	}

	public void setRentBycle(int rentBycle) {
		this.rentBycle = rentBycle;
	}
	
	public void rent (RentalShop rentalShop){
		
		int select = 0;
		Scanner input = new Scanner(System.in);
		
		// rentalShop의 재고수가 빌리고 싶은 자전거수보다 많다면
		if( rentalShop.getBycleStock() >= rentBycle ){
			// 지금의 자전거 재고 수 에서 빌리는 자전거의 개수를 더한다
			this.bycleStock += rentBycle;
		}
		
		//그게 아니라면
		else {
			
			System.out.println("자전거 보유수가 부족합니다.\n"
					 + rentalShop.getBycleStock() + "개 남아있는 자전거를 모두 빌리시겠습니까? "
					 		+ "\n 1:예 2: 아니오");
			
			select = input.nextInt();
			if( select == 1 ){
				
				setRentBycle(rentalShop.getBycleStock());
				this.bycleStock += rentalShop.getBycleStock();
				
			}
			else 
				setRentBycle(0);
		}
		
		rentalShop.loan(this);
		this.money -= (getRentBycle() * rentalShop.getRENTAL_FEE());
	}
	
}
