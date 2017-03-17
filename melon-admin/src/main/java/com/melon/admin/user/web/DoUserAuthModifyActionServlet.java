package com.melon.admin.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.admin.user.service.UserService;
import com.melon.admin.user.service.UserServiceImpl;

public class DoUserAuthModifyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService;
    public DoUserAuthModifyActionServlet() {
    	userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] userAuth = request.getParameterValues("auth");
		
		if(userService.modifyUserAuth(userAuth)){
			response.sendRedirect("/melon-admin/user/list");
		}
		
	}

}
