package com.melon.user.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.user.service.UserService;
import com.melon.user.service.UserServiceImpl;

public class DoCheckDuplicateUserIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private UserService userservice;
    public DoCheckDuplicateUserIdServlet() {
    	userservice= new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		boolean isDuplicate = userservice.isDuplicateUserId(userId);
		
		StringBuffer json = new StringBuffer();
		json.append(" { "); // json 객체를 만드는 것이 자바스크립트와 똑같다. 
		json.append(" \" status\" :  \"success\" ,");
		json.append(" \"duplicated\" : " +isDuplicate);
		json.append(" } ");
		
		PrintWriter writer = response.getWriter();
		writer.write(json.toString());
		writer.flush();
		writer.close();

	}

}
