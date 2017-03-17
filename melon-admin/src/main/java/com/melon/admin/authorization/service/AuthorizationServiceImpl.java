package com.melon.admin.authorization.service;

import java.util.List;

import com.melon.admin.authorization.biz.AuthorizationBiz;
import com.melon.admin.authorization.biz.AuthorizationBizImpl;
import com.melon.admin.authorization.vo.AuthorizationSearchVO;
import com.melon.admin.authorization.vo.AuthorizationVO;

public class AuthorizationServiceImpl implements AuthorizationService{

	AuthorizationBiz authorizationBiz;
	
	public AuthorizationServiceImpl(){
		authorizationBiz = new AuthorizationBizImpl();
	}
	
	@Override
	public boolean addNewAuthorization(AuthorizationVO authorizationVO) {
		return authorizationBiz.addNewAuthorization(authorizationVO);
	}

	@Override
	public List<AuthorizationVO> getAllAuthorization(AuthorizationSearchVO authorizationSearchVO) {
		return authorizationBiz.getAllAuthorization(authorizationSearchVO);
	}

	@Override
	public boolean modifyAuthorizationInfo(AuthorizationVO authorizationVO) {
		return authorizationBiz.modifyAuthorizationInfo(authorizationVO);
	}

	@Override
	public boolean delectOneAuthorizationInfo(String authorizationId) {
		return authorizationBiz.delectOneAuthorizationInfo(authorizationId);
	}

}
