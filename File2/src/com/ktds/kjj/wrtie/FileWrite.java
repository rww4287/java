package com.ktds.kjj.wrtie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {
	
	public void start(){
		
		String filePath = "D:\\makeFile.txt";
		
		try {
			
			PrintWriter printWriter 
							= new PrintWriter(new BufferedWriter( new FileWriter( filePath,true) ) );
			
			//파일에 데이터를 작성한다.
			printWriter.println("파일에 작성합니다 더럽게 복잡하네요ㅜㅜ ");
			
			printWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new FileWrite().start();
	}

}
