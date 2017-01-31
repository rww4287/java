package com.ktds.kjj.seller;
import com.ktds.kjj.buyer.Buyer;
import com.ktds.kjj.vo.BasketVO;

public class Seller {
	
	/**
	 * 상품 가격
	 */
	private final int PRICE = 2500;

	private BasketVO basketVO; //멤버변수 

	public Seller(int productQuantity, int money){
		System.out.println("판매자를 생성합니다!");
		
		basketVO = new BasketVO(); //초기화
		basketVO.setProductQuantity(productQuantity);
		basketVO.setMoney(money);
		
		System.out.println(this);
	}
	
	/**
	 * 판매 하기
	 * @param buyer
	 */
	public void sell(Buyer buyer){
		// 판매자가 가진 상품의 개수에서 하나를 뺀다.
		if ( !isSoldOut() ){
			basketVO.minusproductQuantity();
			
			//구매자의 돈을 지불한다.
			buyer.pay(PRICE);
			
		
			// 판매자가 가진 금액에서 상품의 가격만큼 더한다. 
			basketVO.plusMoney(PRICE);
		}
	}
	
	/**
	 * 재고 파악하기 
	 * @return : boolean 재고가 있으면 false, 재고가없으면 true
	 */
	public boolean isSoldOut(){
		boolean isSoldOut = basketVO.getProductQuantity() == 0;
		return isSoldOut;
	}
	
	/**
	 * 판매자 현황 파악하기
	 */
	@Override
	public String toString(){
		String message = 
				String.format("판매자의 상품 개수 : %d, 판매자가 가진 금액 : %d", 
						basketVO.getProductQuantity(),basketVO.getMoney());
		return message;
	}
	

}
