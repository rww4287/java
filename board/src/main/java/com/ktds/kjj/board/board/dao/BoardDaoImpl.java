package com.ktds.kjj.board.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ktds.kjj.board.board.vo.BoardSearchVO;
import com.ktds.kjj.board.board.vo.BoardVO;
import com.ktds.kjj.board.user.vo.UsersVO;
import com.ktds.kjj.dao.support.JDBCDaoSupport;
import com.ktds.kjj.dao.support.QueryHandler;
import com.ktds.kjj.dao.support.annotation.BindData;

/**
 * Created by Admin on 2017-02-17.
 */
public class BoardDaoImpl extends JDBCDaoSupport implements BoardDao {
    @Override
    public int insertArticle(BoardVO boardVO) {

        return update(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append(" INSERT   INTO BOARD ( ");
                query.append("                          BOARD_ID ");
                query.append("                          , SUBJECT ");
                query.append("                          , CONTENT ");
                query.append("                          , WRITER ");
                query.append("                          , LIKE_COUNT ");
                query.append("                          , WRITE_DATE ");
                query.append("                          , IP ");
                query.append("                          ) ");
                query.append(" VALUES                   ( ");
                query.append("                          BOARD_ID_SEQ.NEXTVAL ");
                query.append("                          , ? ");
                query.append("                          , ? ");
                query.append("                          , ? ");
                query.append("                          , 0 ");
                query.append("                          , SYSDATE");
                query.append("                          , ? ");
                query.append("                          ) ");
                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setString(1, boardVO.getSubject());
                stmt.setString(2, boardVO.getContent());
                stmt.setString(3, boardVO.getWriter());
                stmt.setString(4, boardVO.getIp());

            }

            @Override
            public Object getData(ResultSet rs) {
                return null;
            }
        });
    }

    @Override
    public BoardVO selectOne(int number) {
        return (BoardVO) selectOne(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append(" SELECT   B.BOARD_ID ");
                query.append("          , B.SUBJECT ");
                query.append("          , B.WRITER ");
                query.append("          , B.LIKE_COUNT ");
                query.append("          , B.WRITE_DATE ");
                query.append("          , B.CONTENT ");
                query.append("          , B.IP ");
                query.append("          , U.USR_ID ");
                query.append("          , U.USR_NM ");
                query.append("          , U.JOIN_DT ");
                query.append("FROM       BOARD B ");
                query.append("		     , USRS U ");
                query.append(" WHERE      B.WRITER = U.USR_ID");
                query.append(" AND     	 BOARD_ID = ? ");
                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setInt(1, number);
            }

            @Override
            public Object getData(ResultSet rs) {
            	 BoardVO boardVO = new BoardVO();
                 BindData.startBind(rs, boardVO);
                 
                 UsersVO usersVO = boardVO.getUser();
                 BindData.bindData(rs,usersVO);
                 
                 return boardVO;
            }
        });
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<BoardVO> selectAllArticles(BoardSearchVO boardSearchVO) {
        return selectList(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                
                query.append(" SELECT	* ");
                query.append(" FROM		( ");
                query.append("           SELECT ROWNUM RNUM ");
                query.append("                  , RST.* ");
                query.append("           FROM   ( ");
                query.append(" 						SELECT   B.BOARD_ID ");
                query.append("         						 , B.SUBJECT ");
                query.append("         						 , B.WRITER ");
                query.append("      					     , B.LIKE_COUNT ");
                query.append("  					         , B.WRITE_DATE ");
                query.append("      					     , B.IP ");
                query.append("        						 , U.USR_ID ");
                query.append("         						 , U.USR_NM ");
                query.append("     						     , U.JOIN_DT ");
                query.append("						FROM       BOARD B ");
                query.append("		    					 , USRS U ");
                query.append("						WHERE      B.WRITER = U.USR_ID ");
                query.append("						ORDER      BY BOARD_ID DESC ");
                query.append("                 				   ) RST ");
                query.append("                 	    WHERE ROWNUM <= ?  ");
                query.append("       	    		 )  ");
                query.append(" WHERE				RNUM >= ? ");
                return query.toString();
            }
            
            
            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
            	stmt.setInt(1, boardSearchVO.getPager().getEndArticleNumber());
            	stmt.setInt(2, boardSearchVO.getPager().getStartArticleNumber());
            }

            @Override
            public Object getData(ResultSet rs) {

                BoardVO boardVO = new BoardVO();
                BindData.bindData(rs, boardVO);
                
                UsersVO usersVO = boardVO.getUser();
                BindData.bindData(rs,usersVO);
                
                return boardVO;
            }
        });
    }

    @Override
    public int dropArticle(int number) {
        return update(new QueryHandler() {
            @Override
            public String preparedQuery() {
                StringBuffer query = new StringBuffer();
                query.append(" DELETE ");
                query.append(" FROM      BOARD ");
                query.append(" WHERE     BOARD_ID = ? ");
                return query.toString();
            }

            @Override
            public void mappingParameters(PreparedStatement stmt) throws SQLException {
                stmt.setInt(1, number);
            }

            @Override
            public Object getData(ResultSet rs) {

                return null;
            }
        });
    }

	@Override
	public int update(BoardVO boardVO) {

		return update(new QueryHandler(){
			@Override
			public String preparedQuery() {
				 StringBuffer query = new StringBuffer();
				 query.append("UPDATE	BOARD");
				 query.append(" SET		WRITER = ?");
				 query.append("			,SUBJECT = ?");
				 query.append("			,CONTENT = ?");
				 query.append(" WHERE	BOARD_ID = ?");
				 return query.toString();
			}

			@Override
			public void mappingParameters(PreparedStatement stmt) throws SQLException {
				stmt.setString(1,boardVO.getWriter());
				stmt.setString(2,boardVO.getSubject());
				stmt.setString(3, boardVO.getContent());
				stmt.setInt(4,boardVO.getBoardId());
			}

			@Override
			public Object getData(ResultSet rs) {
				return null;
			}
			
		});
	}

	@Override
	public int getAllArticlesCount(BoardSearchVO boardSearchVO) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		Connection conn= null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String OracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		
		try {
			conn = DriverManager.getConnection(OracleUrl, "BOARD", "board");
			
			StringBuffer query = new StringBuffer();
			query.append(" SELECT	COUNT(B.BOARD_ID) CNT ");
			query.append(" FROM		BOARD B");
			query.append(" 			,USRS U");
			query.append(" WHERE 	B.WRITER=U.USR_ID");
			
			stmt = conn.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			
			if( rs.next() ){
				return rs.getInt("CNT");
			}
		
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
			} catch (SQLException e) {}
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {}
		}
		
	
		return 0;
	}


    
}
