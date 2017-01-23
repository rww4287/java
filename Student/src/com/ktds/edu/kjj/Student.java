package com.ktds.edu.kjj;

public class Student {
	
	//속성
	/*
	 * 이름,학교명,학년,반,교과서
	 */
	private String name = "조정석";
	private String schoolName = "Sejong University";
	private int grade = 4;
	private int classRoomNubmber = 404;
	private String[] books = {"알고리즘" , "난 정말 Java를 공부한적이 없다구욧"};
	
	//instance field 에 대해서 setter 생성 
	/*
	 * name 인스턴스 필드를 갱신함.
	 */
	public void setName(String name){// setter 이기때문에 set을 붙인다. 
		// 파라미터로 전달된 데이터의 길이가 3이면 변경을 해준다. 원하는 데이터만 받을 수 있다.
		if( name.length() == 3){
			this.name = name;
		}
		
	}
	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}
	
	public void setGrade(int grade){
		this.grade = grade;
	}
	
	public void setClassRommNumber(int classRoomNumber){
		this.classRoomNubmber = classRoomNumber;
	}
	public void setBooks(String[] books){
		this.books = books;
	}
	
	
	//기능
	/*
	 * 자기소개를 한다, 공부를한다, 시험을 친다, 교과서를 읽는다.
	 */
	
	public void introduce(){
		String message = String.format("안녕하세요. %s 입니다. %d 학년 %d 반 입니다", name, grade, classRoomNubmber);
		System.out.println(message);
	}
	
	public void study(){
		System.out.println("공부를 합니다.");
		for(int i=0; i < books.length; i++){
			System.out.println(books[i]+" 를 공부하는중~ ");
		}
	}
	
	public void test(){
		System.out.println("시험을 칩니다.");
		for(int i=0; i < books.length; i++){
			System.out.println(books[i]+" 시험을 치는중~ ");
		}
	}
	
	public void reading(){
		for(int i=0; i < books.length; i++){
			System.out.println(books[i]+" 를 읽는중~ ");
		}
	}

}
