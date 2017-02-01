package com.ktds.kjj.management.vo;

//import static com.ktds.kjj.management.vo.Informaition.*;

public class InformationVO implements Information{
	
	private String memberName;
	private String money;
	private String departName;
	//Information informaition = new InformationVO();
	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	
	
}
