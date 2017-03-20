package com.melon.admin.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.melon.admin.authorization.vo.AuthorizationVO;
import com.melon.admin.user.vo.UserSearchVO;
import com.melon.admin.user.vo.UserVO;

public class UserDaoImpl implements UserDao {

	@Override
	public int insertNewUser(UserVO newUserVO) {
		
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
			query.append("                    ,ATHRZTN_ID ");
			query.append("					) ");
			query.append(" VALUES           ( ");
			query.append("                    	? ");
			query.append("                    , ? ");
			query.append("                    , ? ");
			query.append("                    , 0 ");
			query.append("                    , ? ");
			query.append("                  ) ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, newUserVO.getUserId());
			stmt.setString(2, newUserVO.getUserName());
			stmt.setString(3, newUserVO.getUserPassword());
			stmt.setInt(4, newUserVO.getUserPoint());
			stmt.setString(5, newUserVO.getAuthorizationId());
			
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
	public List<UserVO> selectAllUser(UserSearchVO userSearchVO) {
		
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
			query.append(" SELECT	* ");
			query.append(" FROM	( ");
			query.append("			SELECT	ROWNUM AS RNUM ");
			query.append("					, A.* ");
			query.append("			FROM	( ");
			query.append("						SELECT	U.USR_ID ");
			query.append("								, U.USR_NM ");
			query.append("								, U.USR_PWD ");
			query.append("								, U.USR_PNT ");
			query.append("        						, U.ATHRZTN_ID  U_ATHRZTN_ID ");
			query.append("		 						, A.ATHRZTN_ID        ");
			query.append("								, A.ATHRZTN_NM        ");
			query.append("								, A.PRNT_ATHRZTN_ID ");
			query.append("							FROM	USR U ");
			query.append("									,ATHRZTN A ");
			query.append("							WHERE	U.ATHRZTN_ID = A.ATHRZTN_ID(+) ");
			query.append("							ORDER	BY U.USR_ID DESC ");
			query.append("					) A ");
			query.append("			WHERE	ROWNUM <= ? ");
			query.append("		) ");
			query.append(" WHERE	RNUM >= ? ");

			stmt = conn.prepareStatement(query.toString());
			
			stmt.setInt(1, userSearchVO.getPager().getEndArticleNumber());
			stmt.setInt(2, userSearchVO.getPager().getStartArticleNumber());
		
			rs = stmt.executeQuery();
			List<UserVO> user = new ArrayList<UserVO>();
			
			UserVO userVO = null;
			while (rs.next()) {
				userVO = new UserVO();
				userVO.setIndex(rs.getInt("RNUM")); // RNUM을 가지고 인덱스(번호)를 가져온다. 
				userVO.setUserId(rs.getString("USR_ID"));
				userVO.setUserName(rs.getString("USR_NM"));
				userVO.setUserPassword(rs.getString("USR_PWD"));
				userVO.setUserPoint(rs.getInt("USR_PNT"));
				userVO.setAuthorizationId(rs.getString("U_ATHRZTN_ID"));
				
				AuthorizationVO authorizationVO = userVO.getAuthorizationVO();
				
				authorizationVO.setAuthorizationId(rs.getString("ATHRZTN_ID"));
				authorizationVO.setAuthorizationName(rs.getString("ATHRZTN_NM"));
				authorizationVO.setParentAuthorizationId(rs.getString("PRNT_ATHRZTN_ID"));
				
				user.add(userVO);
			}
			
			return user;
			
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
	public UserVO selectOneUser(String userId) {
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

			query.append(" SELECT	U.USR_ID ");
			query.append("			, U.USR_NM ");
			query.append("			, U.USR_PWD ");
			query.append("			, U.USR_PNT ");
			query.append("     		, U.ATHRZTN_ID  U_ATHRZTN_ID ");
			query.append("		 	, A.ATHRZTN_ID        ");
			query.append("			, A.ATHRZTN_NM        ");
			query.append("			, A.PRNT_ATHRZTN_ID ");
			query.append(" FROM		USR U ");
			query.append("			, ATHRZTN A ");
			query.append(" WHERE		U.ATHRZTN_ID = A.ATHRZTN_ID(+) ");
			query.append(" AND		U.USR_ID = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userId);
			rs = stmt.executeQuery();
			
			UserVO userVO = null;
			
			if(rs.next()){
				
				userVO = new UserVO();
				userVO.setUserId(rs.getString("USR_ID"));
				userVO.setUserName(rs.getString("USR_NM"));
				userVO.setUserPassword(rs.getString("USR_PWD"));
				userVO.setUserPoint(rs.getInt("USR_PNT"));
				userVO.setAuthorizationId(rs.getString("U_ATHRZTN_ID"));
				
				AuthorizationVO authorizationVO = userVO.getAuthorizationVO();
				
				authorizationVO.setAuthorizationId(rs.getString("ATHRZTN_ID"));
				authorizationVO.setAuthorizationName(rs.getString("ATHRZTN_NM"));
				authorizationVO.setParentAuthorizationId(rs.getString("PRNT_ATHRZTN_ID"));
			}

			
			return userVO;
			
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

			query.append(" SELECT	U.USR_ID ");
			query.append("			, U.USR_NM ");
			query.append("			, U.USR_PWD ");
			query.append("			, U.USR_PNT ");
			query.append("     		, U.ATHRZTN_ID  U_ATHRZTN_ID ");
			query.append("		 	, A.ATHRZTN_ID        ");
			query.append("			, A.ATHRZTN_NM        ");
			query.append("			, A.PRNT_ATHRZTN_ID ");
			query.append(" FROM		USR U ");
			query.append("			, ATHRZTN A ");
			query.append(" WHERE	U.ATHRZTN_ID = A.ATHRZTN_ID(+) ");
			query.append(" AND		U.ATHRZTN_ID =  'AT-2017032009-000050' ");
			query.append(" AND		U.USR_ID = ? ");
			query.append(" AND		U.USR_PWD = ? ");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserId());
			stmt.setString(2, userVO.getUserPassword());
			
			rs = stmt.executeQuery();
			
			UserVO user = null;
			
			if(rs.next()){
				
				user = new UserVO();
				user.setUserId(rs.getString("USR_ID"));
				user.setUserName(rs.getString("USR_NM"));
				user.setUserPassword(rs.getString("USR_PWD"));
				user.setUserPoint(rs.getInt("USR_PNT"));
				user.setAuthorizationId(rs.getString("U_ATHRZTN_ID"));
				
				AuthorizationVO authorizationVO = user.getAuthorizationVO();
				
				authorizationVO.setAuthorizationId(rs.getString("ATHRZTN_ID"));
				authorizationVO.setAuthorizationName(rs.getString("ATHRZTN_NM"));
				authorizationVO.setParentAuthorizationId(rs.getString("PRNT_ATHRZTN_ID"));
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
	public int updateUserInfo(UserVO userVO) {
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
			

			query.append(" UPDATE USR ");
			query.append(" SET	  ");
			query.append("		  USR_NM = ? ");
			query.append(" 		  , USR_PWD = ? ");
			query.append(" 		  , USR_PNT = ? ");
			query.append(" 		  , ATHRZTN_ID = ? ");
			query.append(" WHERE   USR_ID = ?");
			
			stmt = conn.prepareStatement(query.toString());
			stmt.setString(1, userVO.getUserName());
			stmt.setString(2, userVO.getUserPassword());
			stmt.setInt(3, userVO.getUserPoint());
			stmt.setString(4, userVO.getAuthorizationId());
			stmt.setString(5, userVO.getUserId());
			
			return stmt.executeUpdate();
			
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
	public int updateUserAuth(String[] userAuth) {
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
			
			query.append(" UPDATE USR ");
			query.append(" SET	  ");
			query.append(" 		  ATHRZTN_ID = ? ");
			
			if( userAuth[0] == null || userAuth[0].length() == 0 ){
				query.append(" WHERE   ATHRZTN_ID IS NULL");
			} else {
				query.append(" WHERE   ATHRZTN_ID = ?");
			}
			
			stmt = conn.prepareStatement(query.toString());
			
			if(userAuth[1] == null || userAuth[1].length() == 0 ){
				stmt.setNull(1,Types.VARCHAR);
			} else {
				stmt.setString(1, userAuth[1]);
			}
			
			if(userAuth[0] != null && userAuth[0].length() > 0){
				stmt.setString(2, userAuth[0]);
			} 
			return stmt.executeUpdate();
			
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
	public int delecteOneUser(String userId) {
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
			
			query.append(" DELETE ");
			query.append(" FROM    USR ");
			query.append(" WHERE   USR_ID = ?");
			
			stmt = conn.prepareStatement(query.toString());
			return stmt.executeUpdate();
			
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
	public int selectCountByUserId(UserSearchVO userSearchVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conn = DriverManager.getConnection(url, "MELON", "melon");
			StringBuffer query = new StringBuffer();
			query.append("SELECT	COUNT(1) CNT ");
			query.append("FROM		USR ");
		
			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			
			if(rs.next()){
				return rs.getInt("CNT");
			}
			
			return 0;
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
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
			} catch (SQLException e1) {}
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
		

	}

}
