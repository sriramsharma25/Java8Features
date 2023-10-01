package com.sample;

import java.util.function.BiConsumer;

public class ExceptionHandling {
	
	public static void main(String[] args) {
		int [] someNumbers = {1,2,3,4};
		//int key = 2;
		int key = 2;
		
//		process(someNumbers, key, (v,k) -> {
//			try {
//				System.out.println(v/k);
//			} catch (ArithmeticException ex) {
//				System.out.println("An Arithmetic Exception happened");
//			}
//		});
		
		process(someNumbers, key, wrapperLambda((v,k) -> System.out.println(v/k)));
	}
	
	/*private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
		System.out.println("Executring the wrapper!");
		return (a,b) -> {
			try {
				biConsumer.accept(a, b);
			} catch(ArithmeticException ex) {
				System.out.println("Exception caught in the wrapper lambda!");
			}
		};
	}*/
	
	private static <T, U> BiConsumer<T, U> wrapperLambda(BiConsumer<T, U> biConsumer) {
		System.out.println("Executring the wrapper!");
		return (T, U) -> {
			try {
				biConsumer.accept(T, U);
			} catch(ArithmeticException ex) {
				System.out.println("Exception caught in the wrapper lambda!");
			}
		};
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
		// TODO Auto-generated method stub
		for(int i : someNumbers) {
			biConsumer.accept(i, key);
		}
	}
}
