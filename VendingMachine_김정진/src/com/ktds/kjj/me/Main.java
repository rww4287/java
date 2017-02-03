package com.ktds.kjj.me;

import com.ktds.kjj.me.biz.VendingMachineBiz;
import com.ktds.kjj.me.biz.VendingMachineBizImpl;

import java.util.Scanner;

public class Main {

	public void start(){
		VendingMachineBiz vendingMachineBiz = new VendingMachineBizImpl();
		
		System.out.println("Welcome VendingMachine!!~!~!");
		vendingMachineBiz.setHavingMoney();
		vendingMachineBiz.insertMoney();
	}
	
	public static void main(String[] args) {
		new Main().start();
	}
}
