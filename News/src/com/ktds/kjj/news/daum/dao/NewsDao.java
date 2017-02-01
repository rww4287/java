package com.ktds.kjj.news.daum.dao;

import java.util.List;

import com.ktds.kjj.news.daum.vo.NewsVO;

public interface NewsDao {
	
	public List<NewsVO> queryAllNews();
	
	public void addNewNews(NewsVO newsVO);
	
}
