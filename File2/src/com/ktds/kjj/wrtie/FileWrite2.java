package com.ktds.kjj.wrtie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite2 {
	
	public void start(){
		
		String filePath = "D:\\makeFile.txt";
		
		try {
			// 파일에 데이터를 작성할 수 있도록 지원해주는 클래스
			FileWriter fileWriter = new FileWriter( filePath, true );
			
			// 메모리에 있는 내용을 손실시키지 않고 파일에 쓰도록 지원해주는 클래스
			// 메모리의 데이터를 FileWriter에게 전달해주는 역할
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			// 작성하려는 데이터를 메모리에 적절히 적재 시킬 수 있도록 지원해주는 클래스
			// 데이터를 BufferedWriter에게 전달해주는 역할
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			
			//파일에 데이터를 작성한다.
			printWriter.println("파일에 작성합니다 더럽게 복잡하네요ㅜㅜ ");
			
			printWriter.close();
			bufferedWriter.close();
			fileWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new FileWrite2().start();
	}

}
