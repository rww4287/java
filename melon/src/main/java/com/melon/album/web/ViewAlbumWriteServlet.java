package com.melon.album.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.melon.album.biz.AlbumBiz;
import com.melon.album.biz.AlbumBizImpl;
import com.melon.album.vo.AlbumVO;
import com.melon.common.web.MultipartHttpServletRequest;
import com.melon.common.web.MultipartHttpServletRequest.MultipartFile;

public class ViewAlbumWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	AlbumBiz albumBiz;
    public ViewAlbumWriteServlet() {
        albumBiz = new AlbumBizImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/album/write.jsp");
		
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MultipartHttpServletRequest multipart = new MultipartHttpServletRequest(request);
		
		
		String artistId = request.getParameter("artistId");
		String albumName = multipart.getParameter("albumName");
		String releaseDate = multipart.getParameter("releaseDate");
		String publisher = multipart.getParameter("publisher");
		String entertainment = multipart.getParameter("entertainment");
		String genre = multipart.getParameter("genre");
		String postFileName = "";

		
/*		 폼으로 전송된 파일.
		post 는 write.jsp가 보내준 파일의 이름 (사용자가 올려준 사진파일) */
		MultipartFile post = multipart.getFile("post");
		if( post != null && post.getFileSize() > 0 ){
			
			postFileName = post.getFileName();
			
			File dir = new File("D:\\uploadFiles\\post\\" + artistId + File.separator + albumName);
			dir.mkdirs();
			post.write(dir.getAbsolutePath() + File.separator + post.getFileName());
		}
		
		AlbumVO albumVO = new AlbumVO();
		albumVO.setAlbumName(albumName);
		albumVO.setArtistId(artistId);
		albumVO.setEntertainment(entertainment);
		albumVO.setGenre(genre);
		albumVO.setPost(postFileName);
		albumVO.setPublisher(publisher);
		albumVO.setReleaseDate(releaseDate);
		
		if ( albumBiz.addNewAlbum(albumVO) ){
			StringBuffer script = new StringBuffer();
			script.append("<script type='text/javascript'>");
			script.append(" 	self.close();");
			script.append("</script>");
			
			PrintWriter writer = response.getWriter();
			writer.write(script.toString());
			writer.flush();
			writer.close();
			
		}
		else {
			response.sendRedirect("/melon/album/write");
		}
	}

}
