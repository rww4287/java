package com.ktds.kjj.board.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.kjj.board.board.biz.BoardBiz;
import com.ktds.kjj.board.board.biz.BoardBizImpl;
import com.ktds.kjj.board.board.vo.BoardVO;

public class ViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BoardBiz boardBiz;
	
    public ViewDetailServlet() {
    	boardBiz = new BoardBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		String boardIdString = request.getParameter("boardId");
	
		int boardId = 0;
		
		try {
			boardId = Integer.parseInt(boardIdString);
		}
		catch(NumberFormatException e){
			throw new RuntimeException("존재하지 않는  게시물 입니다.");
		}
		
		BoardVO board = boardBiz.getOneArticles(boardId);
		
		request.setAttribute("board", board);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/board/detail.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
