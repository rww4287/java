package com.ktds.kjj.news.daum;

import java.util.Scanner;

import com.ktds.kjj.news.biz.NewsBiz;
import com.ktds.kjj.news.biz.NewsBizImpl;

public class NewsController {
	
	public void start(){
		int choose = 0;
		Scanner input = new Scanner(System.in);
		NewsBiz newsBiz = new NewsBizImpl();
		
		while ( true ){
			System.out.println("========= 뉴스 =========");
			System.out.println("1. 전체 뉴스 기사 제목 조회");
			System.out.println("2. 뉴스 기사  등록");
			System.out.println("3. 종료");
			System.out.println("======================");
			choose = input.nextInt();
			if ( choose == 1 ){
				newsBiz.queryAllNews();
			}
			else if ( choose == 2 ){
				newsBiz.addNewNews();
			}
			else {
				break;
			}
		}
	}
	public static void main(String[] args) {
		new NewsController().start();
	}

}
