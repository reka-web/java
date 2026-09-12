package com.example.lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("Hi.. ");
		list.add( "demo");
		list.add("Hi.. ");
		list.add( "demo");
		list.add("list");
		list.add(1,"Hello..");
		Stream<String> s1 = list.stream();
		//s1.forEach(System.out::println);
		//s1.forEachOrdered(System.out::println);
		long count = list.stream().filter( n-> n.startsWith("H")).count(); //no of elements starts with H
		System.out.println("count : "+ count);
		//save to set , to remove duplicate.
		Set<String> set = list.stream().collect(Collectors.toSet());
		System.out.println("distinct set : "+ set);
		
		
		String[]  courses = {"java", "c", "c++", "phyton", "AI"};
		Stream s2 = Arrays.stream(courses);
		s2
		//.map(String::toUpperCase)
		.forEach(System.out::println);
	
		
		Stream<Integer> s3 = Stream.of(11,11,12,13,14,13,15,16,17);
		//s3.forEach(System.out::println);
		s3.sorted()
			.distinct()
			.filter(n -> n%2 == 0) //filter only even
			.map(n->n*10)
			.forEach(System.out::println);
		
		//sum of numbers inn arraylist
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
		int sum = numbers.stream()
		                 .reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum); // Output: 30

		IntStream s6  = IntStream.of(2,4,6,8);
		int s = IntStream.of(2,4,6,8)
		.map(n->n*n)
		.sum();
		
		s6.forEach(System.out::println);
		 
		System.out.println("Sum os squares of integers  " + + s );

	       
	        
		
		List<Integer> numbers1 = Arrays.asList(3, 9, 2, 7);
		int max = numbers1.stream()
		                 .reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		System.out.println("Max = " + max); // Output: 9

		
		List<String> words = Arrays.asList("Java", "Stream", "Reduce");
		String result = words.stream()
		                     .reduce("", (a, b) -> a + " " + b);
		System.out.println(result.trim()); // Output: Java Stream Reduce
		
	
		//create infinite stream
		Stream s4 = Stream.iterate(1, n-> n+1).limit(10);
		s4.forEach(System.out::println);
		
		//get Employees List
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(93,"Ram",35000,"IT"));
		employees.add(new Employee(53,"Zion",65000,"IT"));
		employees.add(new Employee(56,"Kavi",30000,"HR"));
		employees.add(new Employee(76,"Malar",55000,"Accounts"));
		employees.add(new Employee(35,"Arun",45000,"Sales"));
		employees.add(new Employee(37,"Ravi",85000,"IT"));
		
		//IT department alone 
	     employees.stream()
	    .sorted(Comparator.comparing(Employee::getId))
	     //.map( e -> e.getName().toUpperCase())
	    .filter(e -> e.getDepartment() == "IT")
	    .forEach(System.out::println);
		
	    //group by department
	     System.out.println( employees.stream().collect(Collectors.groupingBy(Employee::getDepartment)) );
	 
	     //group by department nos
	     System.out.println( employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting())) );
	     
	     // department wise names  - group and map
	      System.out.println(employees
	                .stream()
	                .collect(Collectors.groupingBy(
	                            Employee::getDepartment,
	                            Collectors.mapping(
	                            		Employee::getName,
	                                Collectors.toList()))));
	     

	     //Department names seperated by,
	     System.out.println( employees.stream()
	    		 .map( e->e.getDepartment())
	    		 .collect(Collectors.joining(",")) );  
	    
	  //highest salary
	     employees.stream()
	     .map(e -> e.getSalary())
	     .sorted(Comparator.reverseOrder())
	     .limit(1)
	    // .findFirst()  
	     .forEach(System.out::println);
	    
	    //highest sal -  department wise
	     System.out.println( employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
	    		 Collectors.maxBy(Comparator.comparing(Employee::getSalary)))) );
	 
	    
	    //lowest sal- departmentwise
	     System.out.println( employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
	    		 Collectors.minBy(Comparator.comparing(Employee::getSalary)))) );
	     
	     //lowest sal
	  employees.stream().map(e -> e.getSalary())
	    		 .sorted().limit(1)
	    		  .forEach(System.out::println);
	    		 
	    
	 
	    
	    //lowest in each department
		
		
		
	}

}

class Employee
{
	int id;
	String name;
	int salary;
	String department;
	
	
	public Employee(int id, String name, int salary, String department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}
	
	
	
}
