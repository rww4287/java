package com.melon.admin.authorization.service;

import java.util.List;

import com.melon.admin.authorization.vo.AuthorizationSearchVO;
import com.melon.admin.authorization.vo.AuthorizationVO;

public interface AuthorizationService {

public boolean addNewAuthorization(AuthorizationVO authorizationVO);
	
	public List<AuthorizationVO> getAllAuthorization(
			AuthorizationSearchVO authorizationSearchVO);
	
	public boolean modifyAuthorizationInfo(AuthorizationVO authorizationVO);
	
	public boolean delectOneAuthorizationInfo(String authorizationId);
}
