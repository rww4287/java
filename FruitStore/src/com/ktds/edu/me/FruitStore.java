package com.ktds.edu.me;

import com.ktds.edu.me.buyer.Buyer;
import com.ktds.edu.me.seller.Seller;

public class FruitStore {

	public void start(){
		
		Buyer woobin = new Buyer(10000);
		Seller jungsuck = new Seller(50000);
		woobin.buy(jungsuck);
		System.out.println(woobin);
		System.out.println(jungsuck);
		
	}
	public static void main(String[] args){
		
		new FruitStore().start();// Main class를 쓰는 방법 new 클래스명.매소드();

	}
}
