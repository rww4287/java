package com.ktds.kjj;

public class LGComputer implements Computer{

	@Override
	public void input() {
		System.out.println("X-키보드로 입력합니다.");
	}

	@Override
	public void compute() {
		System.out.println("AMD CPU로 계산합니다.");
	}

	@Override
	public void store() {
		System.out.println("Western Digital SSD에 저장합니다.");
		
	}
	


}
