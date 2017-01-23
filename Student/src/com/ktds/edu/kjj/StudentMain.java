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
	}

}
