package com.melon.album.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.melon.album.vo.AlbumSearchVO;
import com.melon.album.vo.AlbumVO;
import com.melon.artist.vo.ArtistVO;

public class AlbumDaoImpl implements AlbumDao{

	@Override
	public int insertNewAlbum(AlbumVO albumVO) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			conn = DriverManager.getConnection(url,"MELON","melon");
			StringBuffer query = new StringBuffer();
			
			query.append(" INSERT INTO    ALBM    (	 ALBM_ID " );
			query.append(" 						   , ALBM_NM " );
			query.append("                         , ARTIST_ID ");
			query.append("                         , RLS_DT " );
			query.append("                         , PBLSHR " );
			query.append("                         , ENTMNT ");
			query.append("                         , GNR ");
			query.append("                         , PST ");
			query.append("                         ) ");
			query.append(" VALUES                   (  " );
			query.append("							'AR-' || ");
			query.append("							TO_CHAR(SYSDATE, 'YYYYMMDDHH24') || ");
			query.append("							'-' || ");
			query.append("							LPAD(ARTIST_ID_SEQ.NEXTVAL, 6, '0') ");
			query.append("                        , ? ");
			query.append("                        , ? ");
			query.append("                        , ? ");
			query.append("                        , ? ");
			query.append("                        , ? " );
			query.append("                        , ? " );
			query.append("                        , ? " );
			query.append("                        	) " );
			
			stmt = conn.prepareStatement(query.toString());
			
			
			stmt.setString(1, albumVO.getAlbumName());
			stmt.setString(2, albumVO.getArtistId());
			stmt.setString(3, albumVO.getReleaseDate());
			stmt.setString(4, albumVO.getPublisher());
			stmt.setString(5, albumVO.getEntertainment());
			stmt.setString(6, albumVO.getGenre());
			stmt.setString(7, albumVO.getPost());
			
			return stmt.executeUpdate();
			
                        
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			try {
				if(stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if(stmt != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
		
		
	}

	@Override
	public int selectAllAlbumsCount(AlbumSearchVO albumSearchVO) {
	
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
			query.append("SELECT	COUNT(1) CNT ");
			query.append("FROM		ALBM AL");
			query.append("			, ARTIST AR");
			query.append("WHERE		AL.ARTIST_ID = AR.ARTIST_ID");
			query.append("AND		AR.ARTIST_ID = ?");
	
			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			
			if ( rs.next() ){
				return rs.getInt("CNT");
			}
			
			return 0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
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

	@Override
	public List<AlbumVO> selectAllAlbums(AlbumSearchVO albumSearchVO) {
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
			conn = DriverManager.getConnection(url, "MELON", "melon");
			StringBuffer query = new StringBuffer();
			
			query.append(" SELECT  *");
			query.append(" FROM   ( ");
			query.append("            SELECT  ROWNUM AS RNUM ");
			query.append("                    , A.* ");
			query.append("            FROM    ( SELECT   AL.ALBM_ID ");
			query.append("                    	       , AL.ALBM_NM ");
			query.append("                             , AL.ARTIST_ID ");
			query.append("                             , TO_CHAR(AL.RLS_DT, 'YYYY-MM-DD') RLS_DT "); 
			query.append("                             , AL.PBLSHR ");
			query.append("                             , AL.ENTMNT ");
			query.append("                             , AL.GNR ");
			query.append("                             , AL.PST ");
			query.append("                             , AR.ARTIST_ID AR_ARTIST_ID ");
			query.append("                             , AR.MBR ");
			query.append("                             , AR.DEBUT_DT ");
			query.append("                             , AR.DEBUT_TTL ");
			query.append("                     FROM    ALBM AL ");
			query.append("                            , ARTIST AR ");
			query.append("                     WHERE   AL.ARTIST_ID = AR.ARTIST_ID ");
			query.append("        			   AND		AR.ARTIST_ID = ?");
			query.append("                     ORDER   BY AL.RLS_DT DESC ");
			query.append("                     ) A ");
			query.append("            WHERE   ROWNUM <= ? ");
			query.append("        ) ");
			query.append(" WHERE   RNUM >= ? ");

			
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, albumSearchVO.getArtistId());
			stmt.setInt(2,albumSearchVO.getPager().getEndArticleNumber());
			stmt.setInt(3,albumSearchVO.getPager().getStartArticleNumber());
			
			rs = stmt.executeQuery();
			
			List<AlbumVO> album = new ArrayList<AlbumVO>();
			AlbumVO albumVO = null;
			ArtistVO artistVO = null;
			
			while( rs.next() ){
				albumVO = new AlbumVO();
				albumVO.setAlbumId(rs.getString("ALBM_ID"));
				albumVO.setAlbumName(rs.getString("ALBM_NM"));
				albumVO.setArtistId(rs.getString("ARTIST_ID"));
				albumVO.setReleaseDate(rs.getString("RLS_DT"));
				albumVO.setPublisher(rs.getString("PBLSHR"));
				albumVO.setEntertainment(rs.getString("ENTMNT"));
				albumVO.setGenre(rs.getString("GNR"));
				albumVO.setPost(rs.getString("PST"));
				
				artistVO = albumVO.getArtistVO();
				
				
				artistVO.setArtisId(rs.getString("ARTIST_ID"));
				artistVO.setMember(rs.getString("MBR"));
				artistVO.setDebutDate(rs.getString("DEBUT_DT"));
				artistVO.setDebutTitle(rs.getString("DEBUT_TTL"));
				
				album.add(albumVO);
			}
			
			return album;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e){}
			try {
				if(stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if(stmt != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
	}

	@Override
	public AlbumVO selectOneAlbum(String albumId) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url,"MELON","melon");
			StringBuffer query = new StringBuffer();
			query.append(" SELECT   AL.ALBM_ID ");
			query.append("		   , AL.ALBM_NM ");
			query.append("         , AL.ARTIST_ID ");
			query.append("         , TO_CHAR(AL.RLS_DT, 'YYYY-MM-DD') RLS_DT "); 
			query.append("         , AL.PBLSHR ");
			query.append("         , AL.ENTMNT ");
			query.append("         , AL.GNR ");
			query.append("         , AL.PST ");
			query.append("         , AR.ARTIST_ID AR_ARTIST_ID ");
			query.append("         , AR.MBR ");
			query.append("         , AR.DEBUT_DT ");
			query.append("         , AR.DEBUT_TTL ");
			query.append(" FROM    ALBM AL ");
			query.append("		   , ARTIST AR ");
			query.append(" WHERE    AL.ARTIST_ID = AR.ARTIST_ID ");
			query.append(" AND		AL.ALBM_ID = ?");
			query.append(" ORDER    BY AL.RLS_DT DESC ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, albumId);
			rs = stmt.executeQuery();
			
			AlbumVO albumVO = null;
			ArtistVO artistVO = null;
			if (rs.next()){
				albumVO = new AlbumVO();
				albumVO.setAlbumId(rs.getString("ALBM_ID"));
				albumVO.setAlbumName(rs.getString("ALBM_NM"));
				albumVO.setArtistId(rs.getString("ARTIST_ID"));
				albumVO.setReleaseDate(rs.getString("RLS_DT"));
				albumVO.setPublisher(rs.getString("PBLSHR"));
				albumVO.setEntertainment(rs.getString("ENTMNT"));
				albumVO.setGenre(rs.getString("GNR"));
				albumVO.setPost(rs.getString("PST"));
				
				artistVO = albumVO.getArtistVO();
				
				artistVO.setArtisId(rs.getString("ARTIST_ID"));
				artistVO.setMember(rs.getString("MBR"));
				artistVO.setDebutDate(rs.getString("DEBUT_DT"));
				artistVO.setDebutTitle(rs.getString("DEBUT_TTL"));
				
			}
			return albumVO;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e){}
			try {
				if(stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if(stmt != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
		
	}

	@Override
	public int delecteOneAlbum(String albumId) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			conn = DriverManager.getConnection(url, "MELON", "melon");
			StringBuffer query = new StringBuffer();
			
			query.append("DELETE");
			query.append("FROM	ALBM ");
			query.append("WHERE	ALBM_ID =? ");
			
			stmt = conn.prepareStatement(query.toString());
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}	finally {
			try {
				if(stmt != null){
					stmt.close();
				}
			} catch (SQLException e) {}
			try {
				if(stmt != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
		
		
	
		
		
	}

}
