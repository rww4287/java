package com.ktds.kjj;

public class CalculatorMain {
	
	public static void main(String[] args){
	
		Calculator calculator = new Calculator();
		calculator.printComputeResult();
		calculator.printComputeResult(10, 50);
		
		int paramData = calculator.getAndPrintMultiplicationResult(100, 50);
		int result = calculator.getAndPrintMultiplicationResult(paramData,7);
		
		String message = String.format("%d * %d = %d ",paramData,7,result);
		System.out.println(message);
	}

}
