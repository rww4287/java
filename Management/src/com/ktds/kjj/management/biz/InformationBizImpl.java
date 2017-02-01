package com.ktds.kjj.management.biz;

import java.util.List;
import java.util.Scanner;

import com.ktds.kjj.management.dao.ManagementDao;
import com.ktds.kjj.management.dao.ManagementDaoImpl;
import com.ktds.kjj.management.vo.InformationVO;

public class InformationBizImpl implements InformationBiz{

	private ManagementDao managementDao;
	Scanner input= new Scanner(System.in);
	
	public InformationBizImpl(){
		managementDao = new ManagementDaoImpl();
	}
	@Override
	public void queryAllList() {
		
		List<InformationVO> information = managementDao.queryAllList();
		System.out.println("========= 직원 정보 ========");
		
		for(InformationVO inform : information){
			printImformation(inform);
		}
	
	}
	
	public void printImformation(InformationVO inform) {
		System.out.printf("이름:%s, 부서:%s, 연봉:%s \n"
				, inform.getMemberName(),inform.getDepartName(),inform.getMoney());
	}
	
	@Override
	public void addMember() {

		
		System.out.println("직원 이름을 입력해주세요");
		String name = input.next();
		System.out.println("직원의 부서를 입력해주세요");
		String depart = input.next();
		System.out.println("직원의 연봉을 입력해주세요");
		String money = input.next();
		
		InformationVO inform = new InformationVO();
		
		inform.setMemberName(name);
		inform.setDepartName(depart);
		inform.setMoney(money);
		
		printImformation(inform);
		
		managementDao.addMember(inform);
		
	
	}


	@Override
	public void removerMember() {
		int index = inputIndex();
		managementDao.removerMember(index);

	}
	public int inputIndex() {
		System.out.println("직원의 번호를 입력해주세요");
		int index = input.nextInt();
		return index;
	}

	@Override
	public void updateMember() {
	
		int index = inputIndex();
		
		System.out.println("직원 계급");
		String name = input.next();
		
		InformationVO inform = new InformationVO();
		inform.setMemberName(name);
		printImformation(inform);
		managementDao.updateMember(index,inform);
	}


}
