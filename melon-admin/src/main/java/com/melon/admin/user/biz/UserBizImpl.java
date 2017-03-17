package com.melon.admin.user.biz;

import java.util.ArrayList;
import java.util.List;

import com.melon.admin.common.web.pager.Pager;
import com.melon.admin.user.dao.UserDao;
import com.melon.admin.user.dao.UserDaoImpl;
import com.melon.admin.user.vo.UserSearchVO;
import com.melon.admin.user.vo.UserVO;

public class UserBizImpl implements UserBiz{

	UserDao userDao; 
	
	public UserBizImpl(){
		userDao = new UserDaoImpl();
	}
	@Override
	public boolean addNewUser(UserVO newUserVO) {
		return userDao.insertNewUser(newUserVO) > 0;
	}

	@Override
	public List<UserVO> getAllUser(UserSearchVO userSearchVO) {
		int userCount = userDao.selectCountByUserId(userSearchVO);
		
		Pager pager = userSearchVO.getPager();
		pager.setTotalArticleCount(userCount);
		
		if( userCount == 0 ){
			return new ArrayList<UserVO>();
		}

		
		return userDao.selectAllUser(userSearchVO);
	}

	@Override
	public UserVO getOneUser(String userId) {
		return userDao.selectOneUser(userId);
	}

	@Override
	public UserVO getOneUser(UserVO userVO) {
		return userDao.selectOneUser(userVO);
	}

	@Override
	public boolean modifyUserInfo(UserVO userVO) {
		return userDao.updateUserInfo(userVO) > 0;
	}
	@Override
	public boolean modifyUserAuth(String[] userAuth) {
		return userDao.updateUserAuth(userAuth)>0;
	}

	@Override
	public boolean delecteOneUser(String userId) {
		return userDao.delecteOneUser(userId) > 0;
	}

}
