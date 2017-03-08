package com.ktds.kjj.board.user.biz;

import com.ktds.kjj.board.user.vo.UsersVO;

public interface UsersBiz {
	
	public boolean signUpUser(UsersVO user);
	public UsersVO logInUser(UsersVO user);

}
