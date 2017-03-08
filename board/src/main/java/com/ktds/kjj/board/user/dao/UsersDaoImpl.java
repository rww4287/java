package com.ktds.kjj.board.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ktds.kjj.board.user.vo.UsersVO;

public class UsersDaoImpl implements UsersDao {

	@Override
	public int insertNewUser(UsersVO user) {
		loadOracle();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		String oralceUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			
			conn = DriverManager.getConnection(oralceUrl,"BOARD","board");
			
			  String query =" INSERT   INTO USRS (  " +
					  "				USR_ID  " +
					  "        		, USR_NM  " +
					  "   		    , USR_PWD  " +
					  "     		 , JOIN_DT ) " +
					  " VALUES        (  " +
					  "               ? " +
					  "               , ?  " +
					  "               , ?  " +
					  "               , SYSDATE  " +
					  "               ) ";
			  stmt = conn.prepareStatement(query);
			 
			  stmt.setString(1, user.getUserId());
			  stmt.setString(2, user.getUserName());
			  stmt.setString(3, user.getUserPassword());
			  return stmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("오라클 접속 실패");
			throw new RuntimeException(e.getMessage(), e);
		
		} finally {
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
		
		
	}


	@Override
	public UsersVO signInUser(UsersVO user) {
		
		loadOracle();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			
			conn = DriverManager.getConnection(oracleUrl, "BOARD", "board");
			String query = "SELECT  USR_ID " +
					"        ,USR_NM " +
					"        ,USR_PWD " +
					"        ,JOIN_DT " +
					"FROM    USRS " +
					"WHERE   USR_ID = ? " +
					"AND     USR_PWD = ? ";
			
			stmt = conn.prepareStatement(query);
			
			stmt.setString(1, user.getUserId());
			stmt.setString(2, user.getUserPassword());
			
			rs = stmt.executeQuery();
			
			user = null;
			
			if ( rs.next() ){
				user = new UsersVO();
				user.setUserId(rs.getString("USR_ID"));
				user.setUserName(rs.getString("USR_NM"));
				user.setUserPassword(rs.getString("USR_PWD"));
				user.setJoinDate(rs.getString("JOIN_DT"));

			}
			return user;
		
		
		} catch (SQLException e) {
		
			System.out.println("오라클 접속 실패");
			throw new RuntimeException(e.getMessage(), e);
			
		} finally {
			if(stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {}
		}
	}

	
	
	private void loadOracle() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 로딩 실패");
			e.printStackTrace();
		}
	}
	
	
}
