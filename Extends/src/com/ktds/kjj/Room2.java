package com.ktds.kjj;

public class Room2 {
	
	public static void main(String args[]){
		
		AirCleaner airCleaner = new AirConditioner(); //서브 클래스가 슈퍼클래스에 할당이 된다. 
		airCleaner.powerOn();
	
	}

}
