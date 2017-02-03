package com.ktds.kjj.me;

import com.ktds.kjj.me.biz.VendingMachineBiz;
import com.ktds.kjj.me.biz.VendingMachineBizImpl;
import com.ktds.kjj.me.vo.MoneyVO;

import java.util.Scanner;

public class MainController {

	public void start(){
		VendingMachineBiz vendingMachineBiz = new VendingMachineBizImpl();
		
		vendingMachineBiz.operator();
	}
	
	public static void main(String[] args) {
		new MainController().start();
	}
}
