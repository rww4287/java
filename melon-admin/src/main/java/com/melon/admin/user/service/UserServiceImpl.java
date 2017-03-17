package com.melon.admin.user.service;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.melon.admin.authorization.biz.AuthorizationBiz;
import com.melon.admin.authorization.biz.AuthorizationBizImpl;
import com.melon.admin.authorization.vo.AuthorizationSearchVO;
import com.melon.admin.user.biz.UserBiz;
import com.melon.admin.user.biz.UserBizImpl;
import com.melon.admin.user.vo.UserSearchVO;
import com.melon.admin.user.vo.UserVO;

public class UserServiceImpl implements UserService{

	private UserBiz userBiz; 
	private AuthorizationBiz authorizationBiz;
	public UserServiceImpl(){
		userBiz = new UserBizImpl();
		authorizationBiz = new AuthorizationBizImpl();
	}
	
	@Override
	public boolean addNewUser(UserVO newUserVO) {
		return userBiz.addNewUser(newUserVO);
	}

	@Override
	public List<UserVO> getAllUser(UserSearchVO userSearchVO) {
		return userBiz.getAllUser(userSearchVO);
	}

	@Override
	public UserVO getOneUser(String userId) {
		return userBiz.getOneUser(userId);
	}
	@Override
	public Map<String, Object> getOneUserWithAuthorizations(String userId) {
		AuthorizationSearchVO authorizationSearchVO = new AuthorizationSearchVO();
		authorizationSearchVO.getPager().setPageNumber(0);
		Map<String, Object> user = new HashMap<String,Object>();
		
		/*
		 * 하나의 User와 여러개의 authorizations(여러개의 권한 목록)을 가져오기 위하여.
		 */
		user.put("user", userBiz.getOneUser(userId));
		user.put("authorizations", authorizationBiz.getAllAuthorization(authorizationSearchVO));
		
		return user;
	}
	@Override
	public UserVO getOneUser(UserVO userVO) {
		return userBiz.getOneUser(userVO);
	}

	@Override
	public boolean modifyUserInfo(UserVO userVO) {
		UserVO tempUserVO = getOneUser(userVO.getUserId());
		
		
		// 권한 정보를 수정했다면 
		if ( userVO.getAuthorizationId() != null && userVO.getAuthorizationId().length() > 0 ){
			tempUserVO.setAuthorizationId(userVO.getAuthorizationId());
		} else {
			tempUserVO.setAuthorizationId(null);
		}
		
		if ( userVO.getUserPoint() >0 ){
			tempUserVO.setUserPoint(userVO.getUserPoint());
		}
		if ( userVO.getUserPassword() != null && userVO.getUserPassword().length() > 0 ){
			tempUserVO.setUserPassword(userVO.getUserPassword());
		}
		
		return userBiz.modifyUserInfo(tempUserVO);
		
	}
	@Override
	public boolean modifyUserAuth(String[] userAuth) {
		return userBiz.modifyUserAuth(userAuth);
	}
	@Override
	public boolean modifyUserAllAuth(String[] userArray, String toAuth, String fromAuth) {
		
		UserVO userVO = null;
		for(String userId : userArray){
			userVO = new UserVO();
			userVO.setUserId(userId);
			userVO.setAuthorizationId(toAuth);
			modifyUserInfo(userVO);
		}
		return true;
	}
	@Override
	public boolean delecteOneUser(String userId) {
		return userBiz.delecteOneUser(userId);
	}


}
