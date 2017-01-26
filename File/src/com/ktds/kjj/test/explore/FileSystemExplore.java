package com.ktds.kjj.test.explore;

import java.io.File;

public class FileSystemExplore {
	
	public void printFileSystem(String path){
		
		// 1.File 객체 생성(path정보를 가지는 파일을 만듬)
		File directory = new File(path);
		
		// 2. directory 객체의 내용이 폴더인지 파일인지 구분한다.
		if( directory.isDirectory() ){
			// 2-1. 폴더일 경우 폴더 내부를 탐색한다. 
			//printFileSystem(directory.getAbsolutePath()+ File.separator +?);
		}
		else {
			// 2-2. 파일일 경우 파일의 경로를 출력한다. 
			System.out.println(directory.getAbsolutePath());
		}
		
	}

}
