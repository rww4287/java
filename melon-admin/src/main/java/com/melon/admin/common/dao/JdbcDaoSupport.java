package com.melon.admin.common.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JdbcDaoSupport {
	
	public Object selectOne() {
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
			
/*			StringBuffer query = new StringBuffer();
			query.append("SELECT	'AT-' || TO_CHAR(SYSDATE,'YYYYMMDDHH24') || '-' || LPAD(ARTIST_ID_SEQ.NEXTVAL, 6, '0') SEQ ");
			query.append(" FROM	DUAL");*/
			
			String query= query();
			
			stmt = conn.prepareStatement(query);
			// 파라미터...
			mappingParams(stmt);
			
			rs = stmt.executeQuery();
			
			if( rs.next() ){
				// VO 만들기...
				return bindData(rs);
			}
			
			return null;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally {
			try{
				if(rs != null){
					rs.close();
				}
			}catch (SQLException e) {}
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
	
	public abstract String query();
	
	public abstract void mappingParams(PreparedStatement stmt) throws SQLException;
	
	public abstract Object bindData(ResultSet rs) throws SQLException;

}
