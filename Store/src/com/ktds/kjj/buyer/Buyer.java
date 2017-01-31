package com.ktds.kjj.buyer;
import com.ktds.kjj.seller.Seller;
import com.ktds.kjj.vo.BasketVO;

/**
 * 
 * Seller 에게 상품을 구매하고 금액을 Seller 에게 지불한다. 
 * @author Admin
 *
 */
public class Buyer {
	
	private BasketVO basketVO;
	
	public Buyer(int productQuantity, int money){
		System.out.println("구매자를 생성 합니다!");
		
		//초기값 셋팅
		basketVO = new BasketVO();
		basketVO.setProductQuantity(productQuantity);
		basketVO.setMoney(money);
		
		//현황 출력하기
		System.out.println(this);
	}
	
	/**
	 * 구매하기
	 * 구매자가 가진 상품 개수에 1 더해준다
	 */
	public void buy(Seller seller){
		seller.sell(this); //객체를 넘기는게 아니고 객체(Buyer의 인스턴스)의 메모리주소를 넘긴다.
		basketVO.plusproductQuantity();
	}
	
	/**
	 * 지불하기 
	 * 구매자가 가진 돈에서 지불할 돈을 뺀다
	 * @param money : 지불할 금액
	 */
	public void pay(int money){
		basketVO.minusMoney(money);
	}
	
	/**
	 * 구매자 현황 파악하기
	 */
	
	@Override // Override 를 안할경우, 메모리의 주소를 출력한다. 
	public String toString(){
		String message = String.format("구매한 상품 개수 : %d\n구매자가 가진 금액 : %d", 
								basketVO.getProductQuantity(),basketVO.getMoney());
		return message;
	}
}
