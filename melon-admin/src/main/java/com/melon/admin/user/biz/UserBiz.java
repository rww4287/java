package com.melon.admin.user.biz;

import java.util.List;

import com.melon.admin.user.vo.UserSearchVO;
import com.melon.admin.user.vo.UserVO;

public interface UserBiz {
	
	public boolean addNewUser(UserVO newUserVO);
	
	public List<UserVO> getAllUser(UserSearchVO userSearchVO);
	
	public UserVO getOneUser(String userId); 
	
	public UserVO getOneUser(UserVO userVO);
	
	public boolean modifyUserInfo(UserVO userVO);
	
	public boolean modifyUserAuth(String[] userAuth);
	
	public boolean delecteOneUser(String userId);
	
}
