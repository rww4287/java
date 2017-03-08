package com.ktds.kjj.board.user.dao;

import com.ktds.kjj.board.user.vo.UsersVO;

public interface UsersDao {

	public int insertNewUser(UsersVO user);
	public UsersVO signInUser(UsersVO user);
}
