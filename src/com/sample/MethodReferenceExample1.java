package com.sample;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class MethodReferenceExample1 {
	public static void main(String[] args) {
		
		Thread t = new Thread(MethodReferenceExample1 :: printMessage); //Classname that has the method::methodname
		t.start();
		printMessage();
	}

	private static void printMessage() {
		// TODO Auto-generated method stub
		System.out.println("Hello");
	}
}
