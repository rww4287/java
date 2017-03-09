package com.melon.artist.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.artist.biz.ArtistBiz;
import com.melon.artist.biz.ArtistBizImpl;
import com.melon.artist.vo.ArtistVO;

public class ViewArtistWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArtistBiz artistBiz;
	
    public ViewArtistWriteServlet() {
        artistBiz = new ArtistBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/artist/write.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artistName = request.getParameter("artistName");
		String debutDate = request.getParameter("debutDate");
		String debutTitle = request.getParameter("debutTitle");
		
		System.out.println(artistName);
		System.out.println(debutDate);
		System.out.println(debutTitle);
		ArtistVO artistVO = new ArtistVO();
		artistVO.setMember(artistName);
		artistVO.setDebutDate(debutDate);
		artistVO.setDebutTitle(debutTitle);
		
		if( artistBiz.addNewArtist(artistVO)) {
			PrintWriter out = response.getWriter(); //간단한 응답을 보내기위해 사용하는 객체(PrintWriter) 
			out.write("OK"); //out.write("ok") 
			out.flush();
			out.close();
		}
		
		else {
			PrintWriter out = response.getWriter();
			out.write("FAIL");
			out.flush();
			out.close();
		}
	}

}
