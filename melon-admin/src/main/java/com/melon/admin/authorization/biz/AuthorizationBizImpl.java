package com.melon.admin.authorization.biz;

import java.util.ArrayList;
import java.util.List;

import com.melon.admin.authorization.dao.AuthorizationDao;
import com.melon.admin.authorization.dao.AuthorizationDaoImpl;
import com.melon.admin.authorization.vo.AuthorizationSearchVO;
import com.melon.admin.authorization.vo.AuthorizationVO;
import com.melon.admin.common.web.pager.Pager;

public class AuthorizationBizImpl implements AuthorizationBiz {

	private AuthorizationDao authorizationDao;
	
	public AuthorizationBizImpl(){
		authorizationDao = new AuthorizationDaoImpl();
	}

	@Override
	public boolean addNewAuthorization(AuthorizationVO authorizationVO) {
		String id = authorizationDao.generateNewAuthorizationId();
		authorizationVO.setAuthorizationId(id); // 아이디를 받아와서 authorizationVO에게 넣어준다. 
		// 여기서 id를 집어넣으면 서블릿에 있는 authorizationVO도 같은 메모리를 사용하기때문에
		// (서블릿에서 파라미터를 전달할때 메모리를 주기때문에) return을 하지 않아도 된다.
		// biz, dao, servlet 모두 같은 곳을 바라보고 있다! 
		return authorizationDao.insertNewAuthorization(authorizationVO) > 0;
	}

	@Override
	public List<AuthorizationVO> getAllAuthorization(AuthorizationSearchVO authorizationSearchVO) {
		int authorizationCount = authorizationDao.selectAllAuthorizationCount(authorizationSearchVO);
		
		Pager pager = authorizationSearchVO.getPager();
		pager.setTotalArticleCount(authorizationCount);
		if(authorizationCount == 0 ){
			return new ArrayList<AuthorizationVO>();
		}
		return authorizationDao.selectAllAuthorization(authorizationSearchVO);
	}

	@Override
	public boolean modifyAuthorizationInfo(AuthorizationVO authorizationVO) {
		return authorizationDao.updateAuthorizationInfo(authorizationVO) > 0;
	}

	@Override
	public boolean delectOneAuthorizationInfo(String authorizationId) {
		return authorizationDao.delectOneAuthorizationInfo(authorizationId) > 0;
	}


}
