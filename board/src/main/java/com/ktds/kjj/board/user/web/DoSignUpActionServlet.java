package com.ktds.kjj.board.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.kjj.board.user.biz.UsersBiz;
import com.ktds.kjj.board.user.biz.UsersBizImpl;
import com.ktds.kjj.board.user.vo.UsersVO;

public class DoSignUpActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsersVO user;
	private UsersBiz usersBiz;
	
    public DoSignUpActionServlet() {
    	user = new UsersVO();
    	usersBiz = new UsersBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		
		user.setUserId(userId);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		
		usersBiz.signUpUser(user);
		
		response.sendRedirect("/board/user/signIn");
		
		
	}

}
