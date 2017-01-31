package com.ktds.kjj;

public class ExtendsTest {
	
	
	public void start(){
		//String str1 = new String("Extends Test....");
		String str = "Extends Test...";	
		
		Object obj = new String(str); // super class 
		System.out.println(obj);
	}
	public static void main(String[] args){
		ExtendsTest extendsTest = new ExtendsTest();
		extendsTest.start();
		extendsTest.equals("");
	
	}
}
