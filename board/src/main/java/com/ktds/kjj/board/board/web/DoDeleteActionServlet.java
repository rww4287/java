package com.ktds.kjj.board.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.kjj.board.board.biz.BoardBiz;
import com.ktds.kjj.board.board.biz.BoardBizImpl;

public class DoDeleteActionServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private BoardBiz boardBiz;
	public DoDeleteActionServlet() {
        boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String boardIdString = request.getParameter("boardId");
		int boardId =0;
		try{
			boardId = Integer.parseInt(boardIdString);
		}catch (NumberFormatException e){
			throw new RuntimeException("존재하지 않는  게시물 입니다.");
		}
		
		boardBiz.removeArticle(boardId);
		
		response.sendRedirect("/board/list");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
