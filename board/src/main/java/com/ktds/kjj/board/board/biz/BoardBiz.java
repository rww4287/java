package com.ktds.kjj.board.board.biz;

import java.util.List;

import com.ktds.kjj.board.board.vo.BoardSearchVO;
import com.ktds.kjj.board.board.vo.BoardVO;

/**
 * Created by Admin on 2017-02-17.
 */
public interface BoardBiz {

    public boolean writeArticle(BoardVO boardVO);
    public BoardVO getOneArticles(int boardId);
    public List<BoardVO> getAllArticles(BoardSearchVO boardSearchVO);
    public boolean removeArticle(int boardId);
    public boolean uploadArticle(BoardVO boardVO);

}
