package com.ktds.kjj;

import com.ktds.kjj.buyer.Buyer;
import com.ktds.kjj.seller.Seller;

public class Store {

	public void start(){
		
		
//		Buyer ljs = new Buyer(0, 500000);
//		Buyer jgu = ljs;
//		
//		ljs.buy();
//		
//		System.out.println(ljs);
//		System.out.println(jgu);
		
		Buyer lyj = new Buyer(0,50000);
		Seller nym = new Seller(500,50000);
		lyj.buy(nym);
		
		System.out.println(lyj);
		System.out.println(nym);
		
	
//		System.out.println("장터에 오신것을 환영 합니다!");
//		Buyer kwb = new Buyer(0, 500000);
//		Seller jjs = new Seller(100, 500000);
//		
//		System.out.println("바이어 : 상품 좀 살게요. 이 상품 1개 주세요");
//		jjs.sell();
//		kwb.buy();
//		
//		System.out.println("셀러 : 2500원 입니다.");
//		kwb.pay(2500);
//		
//		System.out.println(jjs);
//		System.out.println(kwb);
	}
	
	public static void main(String[] args){
		
		new Store().start();// Main class를 쓰는 방법 new 클래스명.매소드();

	}
}
