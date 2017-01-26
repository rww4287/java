package com.ktds.kjj.make;

import java.io.File;
import java.io.IOException;

public class MakeFile {
	
	public void start() {
		
		String filePath = "D:\\makeFile.txt";
		
		// Shitf + Ctrl + O 자동 import 해준다.
		File textFile = new File(filePath);
		
		try {
			// 파일을 실제 저장소에 생성한다. 
			if( !textFile.exists())
			textFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		new MakeFile().start();
	}

}
