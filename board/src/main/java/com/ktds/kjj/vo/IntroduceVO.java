package com.ktds.kjj.vo;

public class IntroduceVO {

	private String name;
	private int age;
	private String city;
	private String food;
	
	public String getName() {
		System.out.println("Name Return");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		System.out.println("Age Return");
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		System.out.println("City Return");
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getFood() {
		System.out.println("Food Return");
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	
	
}
