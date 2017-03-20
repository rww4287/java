package com.melon.admin.music.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.admin.music.service.MusicService;
import com.melon.admin.music.service.MusicServiceImpl;
import com.melon.music.vo.MusicVO;

public class ViewLikeCountRankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MusicService musicService;
    public ViewLikeCountRankingServlet() {
    	musicService = new MusicServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MusicVO> list = musicService.getLikeCountRanking();
		
		request.setAttribute("musiclist",list);
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/music/ranking.jsp");
		rd.forward(request, response);
		
		
	}

}
