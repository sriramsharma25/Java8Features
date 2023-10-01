package com.sample.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeFunctions {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		EmployeeFunctions empFunctions = new EmployeeFunctions();
	    empFunctions.populateEmployeeList(employeeList);
	    //Number of male and female employees in the organization?
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		//name of all departments in the organization
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
		//average age of male and female employees
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge))));
		//details of highest paid employee in the organization
		System.out.println(employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary))).get());
		//Get the names of all employees who have joined after 2015
		employeeList.stream().filter(e -> e.getYearOfJoining()>2015).map(Employee::getName).forEach(System.out::println);
		//Count the number of employees in each department
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));
		//System.out.println(employeeList.stream().collect(Collectors.counting()));
		//average salary of each department
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))));
		//Get the details of youngest male employee in the product development department
		System.out.println(employeeList.stream().filter(e -> e.getGender().equalsIgnoreCase("Male") && e.getDepartment().equalsIgnoreCase("Product Development")).collect(Collectors.minBy(Comparator.comparing(Employee::getAge))).get());
		//Who has the most working experience in the organization
		System.out.println(employeeList.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining))).get());
		//How many male and female employees are there in the sales and marketing team?
		System.out.println(employeeList.stream().filter(e -> e.department.equalsIgnoreCase("sales and marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		//What is the average salary of male and female employees?
		System.out.println(employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))));
		//List down the names of all employees in each department?
		Map<String, List<Employee>> employeeeListByDept = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> entrySet = employeeeListByDept.entrySet();
		entrySet.stream().forEach(e -> {
			System.out.println("-------"+e.getKey()+"-----------");
			e.getValue().stream().forEach(s -> System.out.println(s.getName()));
		});
		//average salary and total salary of the whole organization
		System.out.println(employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary)));
		//Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years
		//Map<Boolean, List<Employee>> empMap = 
		employeeList.stream().collect(Collectors.partitioningBy(e -> e.getAge()>25)).entrySet().forEach(e -> {
			if(e.getKey()) {
				System.out.println("Employees Above 25");
			} else {
				System.out.println("Employees below 25");
			}
			e.getValue().stream().forEach(emp -> System.out.println(emp.getName()));
		});
		//Who is the oldest employee in the organization? What is his age and which department he belongs to?
		System.out.println(employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge))).get());
		//First three employee details based on highest salary
		employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);
		//find second largest salary in the list
		System.out.println(employeeList.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().get());
		//find the name of a given employee id
		System.out.println(employeeList.stream().filter(e -> e.getId() == 277).findFirst().get().getName());
		//Highest Salary in each department
		employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).entrySet().forEach(e -> {
			System.out.println(e.getKey());
			System.out.println(e.getValue().get());
		});
		
	}

	private void populateEmployeeList(List<Employee> employeeList) {
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));		
	}
	
}
