package com.ktds.kjj.board.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.kjj.board.board.biz.BoardBiz;
import com.ktds.kjj.board.board.biz.BoardBizImpl;
import com.ktds.kjj.board.board.vo.BoardVO;
import com.ktds.kjj.board.user.vo.UsersVO;

public class DoWriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BoardBiz boardBiz;
	private BoardVO boardVO;
    
    public DoWriteActionServlet() {
    	boardBiz = new BoardBizImpl();
    	boardVO = new BoardVO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();
		UsersVO user = (UsersVO) session.getAttribute("_USER_");
		
		
		String writer = user.getUserName();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		String ip = request.getRemoteAddr();
//		writer = writer + "(" + ip + ")";
		
		
		content = content.replaceAll("\n","<br/>");
		content = content.replaceAll("\r","");
		
		boardVO.setWriter(user.getUserId());
		boardVO.setSubject(subject);
		boardVO.setContent(content);
		boardVO.setIp(ip);
		
		if( boardBiz.writeArticle(boardVO) ) {
			//list페이지로 이동한다.
			response.sendRedirect("/board/list"); //브라우저의 url을 바꿔준다
		}
		else {
			//write페이지로 이동한다. 
			response.sendRedirect("/board/write");
		}
		
		
	}

}
