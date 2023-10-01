package com.sample;

import java.util.Arrays;
import java.util.List;

public class StreamsExample1 {
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("Ramu", "Chand", 40),
			new Person("Charles", "Prince", 45),
			new Person("Tim", "Garry", 40),
			new Person("Chary", "Bennet", 40),
			new Person("Mentor", "Andy", 40)
			);
		
		people.stream()
		.filter(p -> p.getlName().startsWith("C"))
		.forEach(p -> System.out.println(p.getfName()));
		
		System.out.println(people.parallelStream()
			.filter(p -> p.getlName().startsWith("C"))
			.count());
	}
}
