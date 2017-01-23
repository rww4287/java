package com.ktds.me;

public class Stand {
	
	private String button = "스위치";
	private String lamp = "전구";
	private String elec = "전기";
	//String light = "불빛";
	private int light = 0;
	
	public void on(){//접근 가능한 public
		System.out.printf("%s가 들어옵니다.\n",elec);
		
		System.out.println("스탠드를 켭니다.");
		light = 5;
		
		String message = String.format("%s를 눌러서  %s를 켭니다",button,lamp);
		System.out.println(message);
		
		message= String.format("밝기는 %d 입니다", light);
		System.out.println(message);
		
	}
	
	void off(){
		System.out.printf("%s가 나갑니다.\n",elec);
		
		System.out.println("스탠드를 끕니다.");
		
		light = 0;
		
		String message = String.format("%s를 눌러서  %s를 끕니다",button,lamp);
		System.out.println(message);
		
		message= String.format("밝기는 %d 입니다", light);
		System.out.println(message);
		
	}
	
	void brightnessControlUp(){
		if( light > 0 ){//현재 전원이 켜져있는지 꺼져있는지 확인 
			light++;
			System.out.printf("밝기를 조절 합니다. 밝기는 %d입니다\n",light);
		}
		else {
			System.out.println("전원이 꺼져있습니다!");
		}
		
	}
	void brightnessControlDown(){
		if( light > 0 ){
			light--;
			System.out.printf("밝기를 조절 합니다. 밝기는 %d입니다\n",light);
		}
		else {
			System.out.println("전원이 꺼져있습니다!");
		}
	}
	

}
