package com.ktds.kjj;

public class Main {
	
	public static void main(String[] args) {
		
		RentalShop rentalShop = new RentalShop(1000);
		User user = new User(1000000,101);
		
		user.rent(rentalShop);
		
		
		System.out.println("자전거 대여점 현황");
		System.out.print("자전거 보유수 : ");
		System.out.println(rentalShop.getBycleStock());
		System.out.print("대여료 총 합 : ");
		System.out.println(rentalShop.getFee());
		System.out.println("=======================");
		System.out.println("대여자 현황");
		System.out.print("자전거 보유수 : ");
		System.out.println(user.getBycleStock());
		System.out.print("대여료 총 합 : ");
		System.out.println(user.getMoney());
		
	}

}
