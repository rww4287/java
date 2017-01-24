package com.ktds.edu.kjj;

public class StudentMain {
	
	public static void main(String[] args){
		Student jjs = new Student();
		
		jjs.introduce();
		
		//jjs.name = "김우빈";
		jjs.setName("김우빈");
		jjs.setGrade(3);
		jjs.setSchoolName("ktds");
		
		String[] books = {"Angular.js2", "React.js"};
		jjs.setBooks(books);
		
		jjs.introduce();
		jjs.study();
		
		
		Student kjj = new Student();
		kjj.setName("김정진");
		kjj.setGrade(1);
		kjj.setClassRommNumber(401);
		kjj.setSchoolName("ktds university");
		String[] book1 = {"Angular.js2", "React.js"};
		kjj.setBooks(book1); //이렇게 일일이 매번 하기 어려우니까, 생성자를 사용하면 편하다.
		
		kjj.introduce();
		kjj.test();
	}

}
