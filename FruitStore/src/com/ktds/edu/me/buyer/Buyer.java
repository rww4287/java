package com.ktds.edu.me.buyer;
import com.ktds.edu.me.seller.Seller;

public class Buyer {

	/**
	 *  구매자가 가지고 있는 금액
	 */
	private int money;
	
	/**
	 * 현재 있는 과일의 개수
	 */
	private int apple;
	private int banana;
	private int grape;
	
	public Buyer(int money){
		System.out.println("구매자를 생성합니다!");
		setMoney(money);
		
		System.out.print(this);
		
	}
	
	public void setMoney(int money){
		this.money = money;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public void buy(Seller seller){
		int select = seller.sell(this);
		if( select == 0 ){
			this.apple++;
		}
		else if ( select == 1 ){
			this.banana++;
		}
		else if ( select == 2){
			this.grape++;
		}
	}
	
	public void pay(int money){
		this.money-= money;
	}
	
	@Override
	public String toString(){
		String message = 
				String.format("구매자가 가진 금액 은 %d 입니다." +
							"사과의개수 : %d, 바나나의 개수 : %d, 포도의개수 : %d\n"
						,this.money,this.apple,this.banana,this.grape);
		return message;
	}
	
}
