package com.melon.admin.user.service;

import java.util.List;
import java.util.Map;

import com.melon.admin.user.vo.UserSearchVO;
import com.melon.admin.user.vo.UserVO;

public interface UserService {

	public boolean addNewUser(UserVO newUserVO);
	
	public List<UserVO> getAllUser(UserSearchVO userSearchVO);
	
	public UserVO getOneUser(String userId); 
	
	public Map<String,Object> getOneUserWithAuthorizations(String userId);
	
	public UserVO getOneUser(UserVO userVO);
	
	public boolean modifyUserInfo(UserVO userVO);
	
	public boolean delecteOneUser(String userId);
	
}
