package com.melon.admin.user.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.admin.user.service.UserService;
import com.melon.admin.user.service.UserServiceImpl;

public class DoAuthCheckActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserService userService;
    public DoAuthCheckActionServlet() {
        userService = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String toAuth = request.getParameter("toAuth");
		
/*		System.out.println(fromAuth);
		System.out.println(toAuth);*/
		
		String[] userId = request.getParameterValues("checkuser");
		
		if(userService.modifyUserAllAuth(userId, toAuth, null)){
			response.sendRedirect("/melon-admin/user/list");
		}
		else{
			response.sendRedirect("/melon-admin/user/list");
		}
		
	}

}
