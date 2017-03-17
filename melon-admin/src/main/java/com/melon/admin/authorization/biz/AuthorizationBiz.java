package com.melon.admin.authorization.biz;

import java.util.List;

import com.melon.admin.authorization.vo.AuthorizationSearchVO;
import com.melon.admin.authorization.vo.AuthorizationVO;

public interface AuthorizationBiz {

	public boolean addNewAuthorization(AuthorizationVO authorizationVO);
	
	public List<AuthorizationVO> getAllAuthorization(
			AuthorizationSearchVO authorizationSearchVO);
	
	public boolean modifyAuthorizationInfo(AuthorizationVO authorizationVO);
	
	public boolean delectOneAuthorizationInfo(String authorizationId);
}
