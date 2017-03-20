package com.melon.artist.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.melon.artist.biz.ArtistBiz;
import com.melon.artist.biz.ArtistBizImpl;
import com.melon.artist.vo.ArtistVO;
import com.melon.common.constants.AuthConst;
import com.melon.user.vo.UserVO;

public class ViewArtistWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArtistBiz artistBiz;
	
    public ViewArtistWriteServlet() {
        artistBiz = new ArtistBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//페이지를 볼수 없게 만드는 작업이 반드시 필요하다
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("_USER_");
		
		// 권한이 없으면 접근자체가 불가능하게 한다.
		if( user.getAuthorizationId().equals(AuthConst.NORMAL_USER) ){
			response.sendError(404); // 아예 페이지가 없는것처럼 처리를 해준다.
		}
		else if ( user.getAuthorizationId().equals(AuthConst.OPERATOR_USER) || 
				user.getAuthorizationId().equals(AuthConst.ADMIN_USER) ){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/artist/write.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Post방법에도 처리를 해줘야한다. 
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("_USER_");
		
		if( user.getAuthorizationId().equals(AuthConst.NORMAL_USER) ){
			response.sendError(404); // 아예 페이지가 없는것처럼 처리를 해준다.
		}
		else if ( user.getAuthorizationId().equals(AuthConst.OPERATOR_USER) || 
				user.getAuthorizationId().equals(AuthConst.ADMIN_USER) ){
			
			String artistName = request.getParameter("artistName");
			String debutDate = request.getParameter("debutDate");
			String debutTitle = request.getParameter("debutTitle");
			
			
			ArtistVO artistVO = new ArtistVO();
			artistVO.setMember(artistName);
			artistVO.setDebutDate(debutDate);
			artistVO.setDebutTitle(debutTitle);
			
			if( artistBiz.addNewArtist(artistVO)) {
				PrintWriter out = response.getWriter(); //간단한 응답을 보내기위해 사용하는 객체(PrintWriter) 
				out.write("OK"); //out.write("ok") 
				out.flush();
				out.close();
			}
			
			else {
				PrintWriter out = response.getWriter();
				out.write("FAIL");
				out.flush();
				out.close();
			}
		}
		

	}

}
