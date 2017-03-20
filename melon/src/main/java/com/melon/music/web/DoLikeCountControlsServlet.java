package com.melon.music.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.melon.music.service.MusicService;
import com.melon.music.service.MusicServiceImpl;
import com.melon.music.vo.MusicVO;

public class DoLikeCountControlsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MusicService musicService;
    
    public DoLikeCountControlsServlet() {
    	musicService = new MusicServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String musicId = request.getParameter("musicid");
		//System.out.println(musicId);
		
		boolean isSuccess = musicService.increaseMusicCount(musicId);
		
		MusicVO music = musicService.getOneMusic(musicId, null);
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("status", isSuccess? "success":"fail");
		map.put("music", music);
		
		Gson gson = new Gson();
		String json = gson.toJson(map);
		
		PrintWriter writer = response.getWriter();
		
		writer.write(json);
		writer.flush();
		writer.close();
		
	}

}
