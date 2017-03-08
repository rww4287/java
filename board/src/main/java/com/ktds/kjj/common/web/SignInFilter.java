package com.ktds.kjj.common.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ktds.kjj.board.user.vo.UsersVO;

public class SignInFilter implements Filter {
    public SignInFilter() {
      
    }

	public void destroy() {
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest rq = (HttpServletRequest)request;
		UsersVO user = (UsersVO) rq.getSession().getAttribute("_USER_");
		
	
		if( user == null){
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("/board/user/signUp");
			return;
		}

		
		chain.doFilter(request,response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
