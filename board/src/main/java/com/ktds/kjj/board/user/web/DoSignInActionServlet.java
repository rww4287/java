package com.ktds.kjj.board.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.kjj.board.user.biz.UsersBiz;
import com.ktds.kjj.board.user.biz.UsersBizImpl;
import com.ktds.kjj.board.user.vo.UsersVO;

public class DoSignInActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsersVO userVO;
    private UsersBiz usersbiz;
  
    public DoSignInActionServlet() {
    	userVO = new UsersVO();
    	usersbiz = new UsersBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println(request.getParameter("userId"));
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		
		userVO.setUserId(userId);
		userVO.setUserPassword(userPassword);
		
		userVO = usersbiz.logInUser(userVO);
		
		
		if(userVO == null){
			response.sendRedirect("/board/user/signIn");
		}
		
		else {
			
			HttpSession session = request.getSession();
			session.setAttribute("_USER_", userVO);
			
			System.out.println("Id: "+userVO.getUserId());
			System.out.println("Pwd: "+userVO.getUserPassword());
			System.out.println("Name: "+userVO.getUserName());
			System.out.println("JoinDate: "+userVO.getJoinDate());
			response.sendRedirect("/board/list");
		
		}
		
	}

}
