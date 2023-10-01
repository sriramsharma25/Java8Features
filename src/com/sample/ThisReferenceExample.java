package com.sample;

public class ThisReferenceExample {
	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	private void execute() {
		// TODO Auto-generated method stub
		doProcess(10, (int i) -> {
			System.out.println("Value of i is::"+i);
			System.out.println(this);
		});
	}
	
	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, (int i) -> {
				System.out.println("Value of i is::"+i);
			});
		thisReferenceExample.execute();
	}
}
