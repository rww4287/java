package com.ktds.kjj.management.dao;

import java.util.ArrayList;
import java.util.List;

import com.ktds.kjj.management.vo.InformationVO;

public class ManagementDaoImpl implements ManagementDao{
	
	List<InformationVO> informationVO;
	
	public ManagementDaoImpl(){
		informationVO = new ArrayList();
	}
	@Override
	public List<InformationVO> queryAllList() {
		return informationVO;
	}

	@Override
	public void addMember(InformationVO information) {
		informationVO.add(information);
		
	}
	@Override
	public void removerMember(int index) {
		informationVO.remove(index);
		
	}

	@Override
	public void updateMember(int index, InformationVO information) {
		informationVO.set(index, information);
	}

	

}
