package com.ktds.kjj.board.board.dao;

import java.util.List;

import com.ktds.kjj.board.board.vo.BoardSearchVO;
import com.ktds.kjj.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public interface BoardDao {

    public int insertArticle(BoardVO boardVO);
    public BoardVO selectOne(int number);

    public int getAllArticlesCount(BoardSearchVO boardSearchVO);
    public List<BoardVO> selectAllArticles(BoardSearchVO searchVO);
    
    public int dropArticle(int number);
    public int update(BoardVO boardVO);




}
