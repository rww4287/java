package com.melon.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.melon.user.vo.UserVO;

public class UserDaoImpl implements UserDao{

	@Override
	public int insertNewUser(UserVO userVO) {
		
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
			query.append(" INSERT  INTO USR (");
			query.append("                     USR_ID ");
			query.append("                    ,USR_NM ");
			query.append("                    ,USR_PWD ");
			query.append("                    ,USR_PNT ");
			query.append("					) ");
			query.append(" VALUES           ( ");
			query.append("                    	? ");
			query.append("                    , ? ");
			query.append("                    , ? ");
			query.append("                    , 0 ");
			query.append("                  ) ");
			
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserName());
			stmt.setString(3, userVO.getUserPassword());
			
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
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
	}

	@Override
	public UserVO selectOneUser(UserVO userVO) {
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
			
			query.append("SELECT  U.USR_ID ");
			query.append("        , U.USR_NM ");
			query.append("        , U.USR_PWD ");
			query.append("        , U.USR_PNT ");
			query.append("        , U.ATHRZTN_ID  U_ATHRZTN_ID ");
			query.append("		  , A.ATHRZTN_ID        ");
			query.append("		  , A.ATHRZTN_NM        ");
			query.append("		  , A.PRNT_ATHRZTN_ID ");
			query.append("FROM    USR  U ");
			query.append("	     , ATHRZTN A ");
			query.append("WHERE   U.ATHRZTN_ID = A.ATHRZTN_ID ");
			query.append("AND     USR_ID = ? ");
			query.append("AND     USR_PWD = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserPassword());
			
			rs = stmt.executeQuery();
			
			UserVO user = null;
			
			if ( rs.next() ){
				user = new UserVO();
				user.setUserId(rs.getString("USR_ID"));
				user.setUserName(rs.getString("USR_NM"));
				user.setUserPassword(rs.getString("USR_PWD"));
				user.setUserPoint(rs.getInt("USR_PNT"));
				user.setAuthorizationId(rs.getString("U_ATHRZTN_ID"));
				user.getAuthorizationVO().setAuthorizationId(rs.getString("ATHRZTN_ID"));
				user.getAuthorizationVO().setAuthorizationName(rs.getString("ATHRZTN_NM"));
				user.getAuthorizationVO().setParentAuthorizationId(rs.getString("PRNT_ATHRZTN_ID"));
				
			}
			return user;
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
	public int updatePoint(String userId, int point) {
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
			
			query.append(" UPDATE	USR ");
			query.append(" SET		USR_PNT = USR_PNT + ? ");
			query.append(" WHERE		USR_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			
			stmt.setInt(1, point);
			stmt.setString(2, userId);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		}finally {
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
	public int selectCountByUserId(String userId) {
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
			query.append("FROM		USR ");
			query.append("WHERE		USR_ID= ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				return  rs.getInt("CNT");
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
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
	
	}

}
