package com.ktds.kjj.make;

import java.io.File;

public class MakeDirectories {
	
	public void start(){
		
		String directoryPath = "D:\\game\\mobile\\poketmon\\go";
		
		File game = new File(directoryPath);
		
		//게임 폴더가 존재하지 않는다면, 생성한다.
		if( !game.exists())
			game.mkdirs();
		
	}
	public static void main(String[] args){
		new MakeDirectories().start();
	}

}
