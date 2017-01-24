package com.ktds.edu.me.seller;

import java.util.Scanner;
import com.ktds.edu.me.buyer.Buyer;

public class Seller {
	
	/**
	 *  판매자가 가지고 있는 금액
	 */
	private int money;
	
	/**
	 * 현재 있는 과일의 개수
	 */
	private int apple;
	private int banana;
	private int grape;
	/**
	 * 과일의 금액
	 */
	private final int PRICE = 1500; 
	
	/**
	 * Seller 생성자 
	 * @param money
	 */
	public Seller(int money){
		System.out.println("판매자 생성 합니다!");
		setMoney(money);
		
		// 현재 있는 사과, 바나나, 포도의 개수를 입력 받는다. 
		System.out.println("현재 있는 사과,바나나,포도의 개수를 입력하세요:");
		Scanner input = new Scanner(System.in);
		this.apple= input.nextInt();
		this.banana=input.nextInt();
		this.grape=input.nextInt();
		
		System.out.print(this);
		
	
	}
	
	/**
	 * 판매자의 현재 금액을 초기화 또는 갱신함 
	 * @param money
	 */
	public void setMoney(int money){
		this.money = money;

	}
	/**
	 * 판매자의 현재 금액을 반환함 
	 * @return
	 */
	public int getMoney(){
		return this.money;
	}
	/**
	 * 제품 팔기
	 * 제품이 팔릴때마다 해당 제품 수가 1 줄어든다. 
	 * 판매자의 현재금액은 1500 만큼 늘어난다. 
	 */
	public int sell(Buyer buyer){
		System.out.println("사고자 하는 과일을 입력하세요!");
		System.out.println("0 : 사과 , 1: 바나나 , 2: 포도 ");
		Scanner input = new Scanner(System.in);
		int select = input.nextInt();
		
		selectFruit(select);
		
		buyer.pay(PRICE);
		this.money += PRICE;
		return select;

	}

	public void selectFruit (int select){
		if( select == 0 ){
			this.apple--;
		}
		else if ( select == 1 ){
			this.banana--;
		}
		else if ( select == 2){
			this.grape--;
		}
		else {
			System.out.println("잘못 입력 하셨습니다!");
		}
	}
	/**
	 * 판매자 현황 파악하기
	 */
	@Override
	public String toString(){
		String message = 
				String.format("판매자가 가진 금액은  %d 입니다. "
						+ "사과의개수 : %d, 바나나의 개수 : %d, 포도의개수 : %d\n"
						, this.money,this.apple,this.banana,this.grape);
		return message;
	}

}
