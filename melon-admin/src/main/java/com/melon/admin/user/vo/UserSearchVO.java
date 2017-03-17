package com.melon.admin.user.vo;

import com.melon.admin.common.web.pager.Pager;
import com.melon.admin.common.web.pager.PagerFactory;

public class UserSearchVO {
	
	private Pager pager;

	public Pager getPager() {
		if(pager == null){
			// 50개 한그룹당 10개 페이지를 보여준다
			pager = PagerFactory.getPager(Pager.ORACLE,50,10); 
		}
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}
	

}
