package com.sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FirstExercise {
	
	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("Ramu", "Chand", 40),
			new Person("Charles", "Prince", 45),
			new Person("Tim", "Garry", 40),
			new Person("Chary", "Bennet", 40),
			new Person("Mentor", "Andy", 40)
			);
		//Sort the list buy lastName
		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getlName().compareTo(o2.getlName());
			}
		});
		
		//Method to print all elements in the list
		prinAll(people);
		
		//Method to print all people whose lastname begins with C
		printLastNameWithC(people);
		printConditional(people, new Condition() {
			@Override
			public boolean test(Person p) {
				// TODO Auto-generated method stub
				return p.getfName().startsWith("C");
			}
		});
		
	}

	private static void printConditional(List<Person> people, Condition condition) {
		// TODO Auto-generated method stub
		System.out.println();
		for(Person p : people) {
			if(condition.test(p)) {
				System.out.println(p);
			}
		}
	}

	private static void printLastNameWithC(List<Person> people) {
		// TODO Auto-generated method stub
		System.out.println();
		for(Person p : people) {
			if(p.getlName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}

	private static void prinAll(List<Person> people) {
		// TODO Auto-generated method stub
		for(Person p : people) {
			System.out.println(p);
		}
	}
}


interface Condition {
	boolean test(Person p);
}