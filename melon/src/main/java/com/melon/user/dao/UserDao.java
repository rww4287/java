package com.melon.user.dao;

import com.melon.user.vo.UserVO;

public interface UserDao {
	
	public int insertNewUser(UserVO userVO);
	
	public UserVO selectOneUser(UserVO userVO);
	
	public int updatePoint(String userId, int point);
	
	// 아이디 중복검사를 위한 매서드.
	public int selectCountByUserId(String userId); 
}
