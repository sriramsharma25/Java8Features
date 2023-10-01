package com.sample.flatmaps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EKartDatabase {

	public static List<Customer> getAll() {
		return Stream.of(
				new Customer(1, "Ramu", "ramu@gmail.com", Arrays.asList("3456469898", "5674469867")),
				new Customer(2, "Somu", "somu@gmail.com", Arrays.asList("4679896678", "6379098678")),
				new Customer(3, "Madhan", "madhan@gmail.com", Arrays.asList("5348906648", "7690092334")),
				new Customer(4, "Chandan", "chandan@gmail.com", Arrays.asList("6128900765", "8129028745")))
		.collect(Collectors.toList());
	
	}
}
