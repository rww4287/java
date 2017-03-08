package com.ktds.kjj.board.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.kjj.board.board.biz.BoardBiz;
import com.ktds.kjj.board.board.biz.BoardBizImpl;
import com.ktds.kjj.board.board.vo.BoardVO;

public class DoModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BoardBiz boardBiz;
	private BoardVO boardVO;
       
    public DoModifyActionServlet() {
    	boardBiz = new BoardBizImpl();
    	boardVO = new BoardVO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardIdString = request.getParameter("boardId");
		String writer = request.getParameter("writer");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		int boardId = 0;
		try{
			boardId = Integer.parseInt(boardIdString);
		}
		catch(NumberFormatException e){
			throw new RuntimeException("존재하지 않는  게시물 입니다.");
		}
		
		boardVO.setBoardId(boardId);
		boardVO.setWriter(writer);
		boardVO.setSubject(subject);
		boardVO.setContent(content);
		
		
		if( boardBiz.uploadArticle(boardVO) ) {
			//list페이지로 이동한다.
			response.sendRedirect("/board/list"); //브라우저의 url을 바꿔준다
		}
		else {
			//write페이지로 이동한다. 
			response.sendRedirect("/board/modify");
		}
	}

}
