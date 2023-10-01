package com.sample.methodrefs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

class StaticMR {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);

		// Using an anonymous class
		findNumbers(list, new BiPredicate<Integer, Integer>() {
		  public boolean test(Integer i1, Integer i2) {
		    return StaticMR.isMoreThanFifty(i1, i2);
		  }
		});

		// Using a lambda expression
		findNumbers(list, (i1, i2) -> StaticMR.isMoreThanFifty(i1, i2));

		// Using a method reference
		findNumbers(list, StaticMR::isMoreThanFifty);
	}
	
	  public static boolean isMoreThanFifty(int n1, int n2) {
	    return (n1 + n2) > 50;
	  }
	  public static List<Integer> findNumbers(
	    List<Integer> l, BiPredicate<Integer, Integer> p) {
	      List<Integer> newList = new ArrayList<>();
	      for(Integer i : l) {
	        if(p.test(i, i + 10)) {
	          newList.add(i);
	        }
	      }
	      return newList;
	  }
	}