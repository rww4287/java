package com.melon.music.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.common.web.DownloadUtil;
import com.melon.music.biz.MusicBiz;
import com.melon.music.biz.MusicBizimpl;
import com.melon.music.vo.MusicVO;

public class ViewMusicPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MusicBiz musicBiz;
    public ViewMusicPostServlet() {
    	musicBiz = new MusicBizimpl();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicId = request.getParameter("musicId");
		
		MusicVO music = musicBiz.getOneMusic(musicId);
		
		String postPath = "D:\\uploadFiles\\mp3\\";
		
		postPath += music.getAlbumId();
		
		DownloadUtil downlaodUtil = DownloadUtil.getInstance(postPath);
		downlaodUtil.download(request, response, music.getMp3File(),music.getMp3File());
		
	}

}
