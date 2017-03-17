package com.melon.admin.authorization.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.melon.admin.authorization.service.AuthorizationService;
import com.melon.admin.authorization.service.AuthorizationServiceImpl;

public class DoAuthorizationDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private AuthorizationService authorizationService;
    public DoAuthorizationDeleteServlet() {
    	authorizationService = new AuthorizationServiceImpl(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String authorizationId = request.getParameter("authorizationId");
		
		boolean isSuccess = authorizationService.delectOneAuthorizationInfo(authorizationId);
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		if (isSuccess){
			map.put("status", "success");
		}
		else {
			map.put("status", "fail");
		}
		
		map.put("authorizationId", authorizationId);
		Gson gson = new Gson();
		String json = gson.toJson(map);
		
		PrintWriter writer = response.getWriter();
		
		writer.write(json);
		writer.flush();
		writer.close();
	}

}
