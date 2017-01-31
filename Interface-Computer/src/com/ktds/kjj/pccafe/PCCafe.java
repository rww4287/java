package com.ktds.kjj.pccafe;

import com.ktds.kjj.AppleComputer;
import com.ktds.kjj.Computer;
import com.ktds.kjj.LGComputer;
import com.ktds.kjj.SamsungComputer;

public class PCCafe {
	
	public static void main(String[] args) {
		
		Computer[] computers = new Computer[5];
		
		computers[0] = new SamsungComputer();
		computers[1] = new LGComputer();
		computers[2] = new SamsungComputer();
		computers[3] = new AppleComputer();
		computers[4] = new LGComputer();
		
		for(Computer computer : computers ){
			computer.input();
			computer.compute();
			computer.store();
			if ( computer instanceof AppleComputer ){
				((AppleComputer) computer).faceTime();
			}
		}
		
	}

}
