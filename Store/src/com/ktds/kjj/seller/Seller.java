package com.ktds.kjj.seller;
import com.ktds.kjj.buyer.Buyer;

public class Seller {
	
	/**
	 * 상품 가격
	 */
	private final int PRICE = 2500;
	
	/**
	 * 판매자가 가진 금액
	 */
	private int money;
	
	/**
	 * 판매자가 가진 상품의 갯수
	 */
	private int productQuantity;

	/**
	 * 판매하기
	 */
	
	public Seller(int productQuantity, int money){
		System.out.println("판매자를 생성합니다!");
		
		setProductQuantity(productQuantity);
		setMoney(money);
		
		System.out.println(this);
	}
	
	public void setMoney(int money){
		this.money=money;
	}
	
	public int getMoney(){
		return this.money;
	}
	
	public void setProductQuantity(int productQuantity){
		this.productQuantity = productQuantity;
	}
	
	public int getProductQuantity(){
		return this.productQuantity;
	}
	
	public void sell(Buyer buyer){
		// 판매자가 가진 상품의 개수에서 하나를 뺀다.
		this.productQuantity--;
		
		//구매자의 돈을 지불한다.
		buyer.pay(PRICE);
		
	
		// 판매자가 가진 금액에서 상품의 가격만큼 더한다. 
		this.money += PRICE;
	}
	
	/**
	 * 재고 파악하기 
	 * @return : boolean 재고가 있으면 false, 재고가없으면 true
	 */
	public boolean isSoldOut(){
		boolean isSoldOut = this.productQuantity == 0;
		return isSoldOut;
	}
	
	/**
	 * 판매자 현황 파악하기
	 */
	@Override
	public String toString(){
		String message = 
				String.format("판매자의 상품 개수 : %d, 판매자가 가진 금액 : %d", 
						this.productQuantity,this.money);
		return message;
	}
	

}
