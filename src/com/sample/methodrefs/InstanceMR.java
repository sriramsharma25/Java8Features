package com.sample.methodrefs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class InstanceMR {
	public static void main(String[] args) {
		List<InstanceMR> instanceMRList = new ArrayList<InstanceMR>();
		InstanceMR instaRef = new InstanceMR();
		instanceMRList.add(instaRef);
		instanceMRList.add(instaRef);
		
		// Using an anonymous class
		instaRef.calculateOnShipments(instanceMRList, new Function<InstanceMR, Integer>() {
		  public Integer apply(InstanceMR s) { // The object
		    return s.calculateWeight(); // The method
		  }
		});

		// Using a lambda expression
		instaRef.calculateOnShipments(instanceMRList, s -> s.calculateWeight());

		// Using a method reference
		instaRef.calculateOnShipments(instanceMRList, InstanceMR::calculateWeight);
	}
	
	public Integer calculateWeight() {
		Integer weight = 10;
	    // Calculate weight
	    return weight;
	}
  
	public List<Integer> calculateOnShipments(List<InstanceMR> instanceMRList, Function<InstanceMR, Integer> f) {
		List<Integer> results = new ArrayList<>();
		for(InstanceMR s : instanceMRList) {
			results.add(f.apply(s));
		}
		System.out.println(results);
		return results;
	}
}
