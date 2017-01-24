package com.ktds.kjj;

public class ArmyMain {
	
	public static void main(String[] args){

		//군인 객체를 만들어 주는 클래스
		Army army = new Army();
		
		Person kwb = army.makeArmy("김우빈");
		System.out.println(kwb.getName());
		System.out.println(kwb.getJob());
		
		Person jjs = army.makeArmy("조정석");
		System.out.println(jjs.getName());
		System.out.println(jjs.getJob());
		
	}

}
