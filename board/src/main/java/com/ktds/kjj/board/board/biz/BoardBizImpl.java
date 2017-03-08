package com.ktds.kjj.board.board.biz;

import java.util.ArrayList;
import java.util.List;

import com.ktds.kjj.board.board.dao.BoardDao;
import com.ktds.kjj.board.board.dao.BoardDaoImpl;
import com.ktds.kjj.board.board.vo.BoardSearchVO;
import com.ktds.kjj.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public class BoardBizImpl implements BoardBiz {

    private BoardDao boardDao;

    public BoardBizImpl() {
        this.boardDao = new BoardDaoImpl();
    }

    @Override
    public boolean writeArticle(BoardVO boardVO) {
        return boardDao.insertArticle(boardVO) > 0;
    }

    @Override
    public BoardVO getOneArticles(int boardId) {
        return boardDao.selectOne(boardId);
    }

    @Override
    public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO) {
        
    	int articleCount = boardDao.getAllArticlesCount(boardSearchVO);
    	boardSearchVO.getPager().setTotalArticleCount(articleCount);
    	
    	if(articleCount == 0){
    		return new ArrayList<BoardVO>();
    	} else {
    		
    		return boardDao.selectAllArticles(boardSearchVO);
    	}
    }

    @Override
    public boolean removeArticle(int boardId) {
        return boardDao.dropArticle(boardId) > 0;
    }

	@Override
	public boolean uploadArticle(BoardVO boardVO) {
		return boardDao.update(boardVO) >0;
	}
}
