package com.sample;

public class ClosureExample {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 20; //This frozen value is sent to the doProcess when it is called - Closure
					// This is also effectively final
		doProcess(a, i -> System.out.println(i + b));
	}
	
	private static void doProcess(int i, Process p) {
		// TODO Auto-generated method stub
		p.process(i);
	}
}

interface Process {
	void process(int i);
}
