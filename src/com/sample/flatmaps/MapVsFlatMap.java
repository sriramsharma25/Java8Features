package com.sample.flatmaps;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

	public static void main(String[] args) {
		List<Customer> customers = EKartDatabase.getAll();
		//customer -> customer.getEmail() - One to one mapping
		List<String> customerMailIds = customers.stream().map(customer -> customer.getEmail()).collect(Collectors.toList());
		System.out.println(customerMailIds);
		
		List<List<String>> phoneList = customers.stream().map(customer -> customer.getPhoneNumbers()).collect(Collectors.toList());
		System.out.println(phoneList);
		
		List<String> phoneListWithSingleStream = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).collect(Collectors.toList());
		System.out.println(phoneListWithSingleStream);
	}
}