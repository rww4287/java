package com.ktds.kjj.board.user.biz;

import com.ktds.kjj.board.user.dao.UsersDao;
import com.ktds.kjj.board.user.dao.UsersDaoImpl;
import com.ktds.kjj.board.user.vo.UsersVO;

public class UsersBizImpl implements UsersBiz{

	private UsersDao userDao;
	
	public UsersBizImpl(){
		userDao = new UsersDaoImpl();
	}
	@Override
	public boolean signUpUser(UsersVO user) {
		return userDao.insertNewUser(user)>0;
	}
	
	@Override
	public UsersVO logInUser(UsersVO user) {
		return userDao.signInUser(user);
	}

}
