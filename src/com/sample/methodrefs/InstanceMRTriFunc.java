package com.sample.methodrefs;

public class InstanceMRTriFunc {
	public static void main(String[] args) {
		//Done using inner class
		TriFunction<InstanceMRTriFunc, String, String, Integer> anon =
		  new TriFunction<InstanceMRTriFunc, String, String, Integer>() {
		    @Override
		    public Integer apply(InstanceMRTriFunc s, String arg1, String arg2) {
		      return s.doSum(arg1, arg1);
		    }
		};
		System.out.println(anon.apply(new InstanceMRTriFunc(), "1", "4"));
		
		//Done using Lambdas
		TriFunction<InstanceMRTriFunc, String, String, Integer> lambda = (InstanceMRTriFunc s, String arg1, String arg2) -> s.doSum(arg1, arg2);
		System.out.println(lambda.apply(new InstanceMRTriFunc(), "1", "4"));
		
		//Done using Method Ref
		TriFunction<InstanceMRTriFunc, String, String, Integer> methodRef = InstanceMRTriFunc::doSum;
		System.out.println(methodRef.apply(new InstanceMRTriFunc(), "1", "4"));
	}
	
	Integer doSum(String s1, String s2) {
	    return Integer.parseInt(s1) + Integer.parseInt(s1);
	}		
}


interface TriFunction<T, U, V, R> {
	  R apply(T t, U u, V v);
}