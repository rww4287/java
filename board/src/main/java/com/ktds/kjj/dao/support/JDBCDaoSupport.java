package com.ktds.kjj.dao.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCDaoSupport {

	public List selectList(QueryHandler queryHandler) {
		
		loadOracleDriver();
		
		// 2. JDBC Instance 생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			// Query 생성하기..
			String query = queryHandler.preparedQuery();
			stmt = conn.prepareStatement(query);
			
			// 파라미터 맵핑하기
			queryHandler.mappingParameters(stmt);
			
			rs = stmt.executeQuery();
			
			List result = new ArrayList();
			while(rs.next()) {
				// ROW 객체 생성하기
				result.add(queryHandler.getData(rs));
			}
			
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}
	
	public Object selectOne(QueryHandler queryHandler) {
		
		loadOracleDriver();
		
		// 2. JDBC Instance 생성
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = getConnection();
			
			// Query 생성하기..
			String query = queryHandler.preparedQuery();
			stmt = conn.prepareStatement(query);
			
			// 파라미터 맵핑하기
			queryHandler.mappingParameters(stmt);
			
			rs = stmt.executeQuery();
			
			Object result = null;
			if (rs.next()) {
				// ROW 객체 생성하기
				result = queryHandler.getData(rs);
			}
			
			return result;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}
	public int update(QueryHandler queryHandler) {

		loadOracleDriver();

		// 2. JDBC Instance 생성
		Connection conn = null;
		PreparedStatement stmt = null;


		try {
			conn = getConnection();

			// Query 생성하기..
			String query = queryHandler.preparedQuery();
			stmt = conn.prepareStatement(query);

			// 파라미터 맵핑하기

			queryHandler.mappingParameters(stmt);
			return stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, null);
		}
	}
	
	private void loadOracleDriver() {
		// 1. Oracle Driver Loading.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private Connection getConnection() throws SQLException {
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		return DriverManager.getConnection(oracleUrl, "BOARD", "board");
	}
	
	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
		}
	}
	
}