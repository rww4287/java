package com.ktds.me;

public class StandMain {
	public static void main(String[] args){
		
		Stand stand = new Stand();
		
		//stand.light=10;//접근불가
		
		stand.brightnessControlUp();
		stand.brightnessControlDown();
		stand.on();
		stand.brightnessControlUp();
		stand.brightnessControlDown();
		stand.off();
		
		
	}

}
