package com.melon.admin.user.dao;

import java.util.List;

import com.melon.admin.user.vo.UserSearchVO;
import com.melon.admin.user.vo.UserVO;

public interface UserDao {

	public int insertNewUser(UserVO newUserVO);
	
	public List<UserVO> selectAllUser(UserSearchVO userSearchVO);
	
	/**
	 * 관리자 페이지에서 한명의 회원정보를 보기 위한 메소드
	 * @param userId
	 * @return
	 */
	public UserVO selectOneUser(String userId); 
	
	/**
	 * 로그인을 위한 매소드
	 * @param userVO
	 * @return
	 */
	public UserVO selectOneUser(UserVO userVO);
	
	public int updateUserInfo(UserVO userVO);
	
	public int updateUserAuth(String[] userAuth);
	
	public int delecteOneUser(String userId);
	
	public int selectCountByUserId(UserSearchVO userSearchVO);
}
