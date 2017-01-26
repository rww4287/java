package com.ktds.kjj;

import com.ktds.kjj.helper.FileWriteHelper;

public class Calculator {
	
	public void start() {
		
		int result = 10 + 70;
		String message = String.format("%d + %d = %d",10,70,result);
		System.out.println(message);
		
		FileWriteHelper fileWriteHelper = new FileWriteHelper();
		fileWriteHelper.log(message);
	}

	public static void main(String[] args) {
		
		new Calculator().start();
	}

}
