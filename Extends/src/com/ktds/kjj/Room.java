package com.ktds.kjj;

public class Room {
	
	public static void main(String[] args){
		
		AirConditioner airConditioner = new AirConditioner();
		airConditioner.powerOn();
		airConditioner.cooling();
		
		AirCleaner airCleaner = new AirCleaner();
		airCleaner.powerOn();
	}

}
