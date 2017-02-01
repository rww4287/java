package com.ktds.kjj.news.biz;

import java.util.List;
import java.util.Scanner;

import com.ktds.kjj.news.daum.dao.NewsDao;
import com.ktds.kjj.news.daum.dao.NewsDaoImpl;
import com.ktds.kjj.news.daum.vo.NewsVO;

public class NewsBizImpl implements NewsBiz {

	private NewsDao newsDao;
	
	public NewsBizImpl(){
		newsDao = new NewsDaoImpl();
		
	}
	@Override
	public void queryAllNews() {
	
		List<NewsVO> newsList = newsDao.queryAllNews();
		for ( NewsVO newsVO : newsList ){
			System.out.printf("뉴스 제목 : %s, 언론사 : %s, 기자 : %s \n",
					newsVO.getNewsTitle(),newsVO.getNewsCompany(),newsVO.getReporter());
		}
		
	}
	@Override
	public void addNewNews() {
		Scanner input = new Scanner(System.in);
		System.out.println("등록할 뉴스 제목을 입력해주세요");
		String tempTitle = input.next();
		System.out.println("등록할 뉴스의 언론사를 입력해주세요");
		String tempCompany = input.next();
		System.out.println("등록할 뉴스의 기자 이름을 입력해주세요");
		String tempReporter = input.next();
		
		NewsVO newsVO = new NewsVO();
		
		newsVO.setNewsTitle(tempTitle);
		newsVO.setNewsCompany(tempCompany);
		newsVO.setReporter(tempReporter);
		
		newsDao.addNewNews(newsVO);
		
	}

}
