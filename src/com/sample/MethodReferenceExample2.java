package com.sample;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.print.attribute.standard.PrinterMessageFromOperator;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
			new Person("Ramu", "Chand", 40),
			new Person("Charles", "Prince", 45),
			new Person("Tim", "Garry", 40),
			new Person("Chary", "Bennet", 40),
			new Person("Mentor", "Andy", 40)
			);
		//Sort the list buy lastName
		Collections.sort(people, (p1,p2) -> p1.getlName().compareTo(p2.getlName()));
		
		//Method to print all elements in the list
		printConditional(people, p -> true, System.out :: println);
		
		//Method to print all people whose lastname begins with C
		printConditional(people, p -> p.getfName().startsWith("C"), p->System.out.println(p));
		
	}

	private static void printConditional(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		// TODO Auto-generated method stub
		System.out.println();
		for(Person p : people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}

}
