package com.ktds.kjj;

// 자바는 다중 상속이 지원이 되지 않습니다. 다만 Object라는 클래스는 원래 상속이 되어있다. 
public class AirConditioner extends AirCleaner {
	
	/**
	 * 냉방 설정 온도
	 */
	private int temp = 26;
	
	/**
	 * 전원 켬
	 */
	// AirCleaner에도 powerOn()이 있기 때문에 재정의 한다. (매소드 오버라이딩) 
	@Override
	public void powerOn(){
		
		System.out.println("에어컨을 켭니다.");
		System.out.println("시원해 집니다.");
		
		cooling();
		
		System.out.println("공기 청정기 제조사 : " +super.manufactor);
		System.out.println("공기 청정기 제조 국가 : "+super.origin);
		super.powerOn(); //AirCleaner에 있는 powerOn()을 실행시킨다. (AirCleaner를 super라 지칭한다.)
		
	}
	
	
	/**
	 * 온도 낮추기
	 */
	public void cooling(){
		temp--;
		System.out.println("현재 설정 온도는 " + temp + "도 입니다.");
	}

}
