package com.melon.admin.music.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.melon.music.vo.MusicVO;

public class MusicDaoImpl implements MusicDao {

	public List<MusicVO> allLikeCountRanking(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
	
		try {
			conn = DriverManager.getConnection(url,"MELON","melon");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT  MSC_ID");
			query.append("		, ALBM_ID ");
			query.append("		, TTL            ");
			query.append("		, MP3_FL            ");
			query.append("		, LK_CNT ");
			query.append("		, MSCN            ");
			query.append("		, DRTR            ");
			query.append("		, LRCS            ");
			query.append(" FROM MSC             ");
			query.append(" ORDER  BY LK_CNT DESC  ");
			
			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			
			MusicVO music = null;
			List<MusicVO> musicList = new ArrayList<MusicVO>();
			while (rs.next()){
				music = new MusicVO();
				music.setAlbumId(rs.getString("ALBM_ID"));
				music.setMusicId(rs.getString("MSC_ID"));
				music.setTitle(rs.getString("TTL"));
				music.setMp3File(rs.getString("MP3_FL"));
				music.setLikeCount(rs.getInt("LK_CNT"));
				music.setMusician(rs.getString("MSCN"));
				music.setDirector(rs.getString("DRTR"));
				music.setLyrics(rs.getString("LRCS"));
				
				musicList.add(music);
			}
			return musicList;
	
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {}
			try {
				if(stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
	}


}
