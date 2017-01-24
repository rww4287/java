package com.ktds.edu.kjj;

public class PersonMain {
	
	public static void main(String[] args){
		
		Person kwb = new Person();
		kwb.setName("김우빈");
		kwb.setJob("모델");
		kwb.introduce();
		
		Person jjs = new Person();
		jjs.setName("조정석");
		jjs.setJob("배우");
		jjs.introduce();
		
		Person jjh = new Person(); //생성자
		jjh.setName("전지현");
		jjh.setJob("영화배우");
		jjh.introduce();
		//이렇게 하지말고 객체를 만듬과 동시에 데이터를 초기화 시킨다. (생성자) 
		
		Person unknown = new Person();
		unknown.introduce();
		
		Person ksk = new Person("김슬기","감독");
		ksk.introduce();
	}

}
