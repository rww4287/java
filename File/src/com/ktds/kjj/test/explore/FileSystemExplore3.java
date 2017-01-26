package com.ktds.kjj.test.explore;

import java.io.File;

import jdk.nashorn.internal.runtime.CodeStore.DirectoryCodeStore;

public class FileSystemExplore3 {
	
	public void printFileSystem(String path){
		
		// 1.File 객체 생성(path정보를 가지는 파일을 만듬)
		File directory = new File(path);
		
		File file = null;
		// 1-1. directory 안의 내용을 탐색한다.
		String[] contents = directory.list();
		for (String content : contents){
			// content와 directory의 경로를 결합해 새로운 file 객체를 생성한다.
			file = new File(directory.getAbsolutePath() + File.separator + content);
			// 2. directory 객체의 내용이 폴더인지 파일인지 구분한다.
			
			
			if( file.isDirectory() ){
				// 2-1. 폴더일 경우 폴더 내부를 탐색한다. 
				printFileSystem(file.getAbsolutePath());
			}	
			else {
				// 2-2. 파일일 경우 파일의 경로를 출력한다. 
				System.out.println(file.getAbsolutePath());
			}
		}
		

		
	}

}
