package com.example.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {

	public static void main(String[] args) 
	{
	//lambda method implementaion
		Calculator add = (a,b) ->  a + b; 
		Calculator divide = (a,b) ->  a / b; 
		Calculator power = (a,b) ->  Math.pow(a, b); 
	 //lambda calling
		 System.out.println(add.calculate(5, 8));
		 System.out.println(divide.calculate(16, 8));
		 System.out.println(power.calculate(5, 3));
		 
		 
		 List<Integer> list = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));
		 list.forEach(n-> System.out.print(n));
		 
		 
		 
		 
		 // odd numbers
		 System.out.println("");
		 list.forEach( n-> { if(n%2!=0) System.out.print(n); } );
		 // even numbers
		 System.out.println("");
		 list.forEach( n-> { if(n%2==0) System.out.print(n); } );
		 System.out.println("");
		 
		 //Predicate returns true or false
		 
		  Predicate<Integer> isEven =
		            num -> num % 2 == 0;
		 System.out.println(isEven.test(20));
		 

		 Predicate<String> isEmpty = n -> n.isEmpty(); 
		 System.out.println(isEmpty.test( ""));
		 
		 //get list of admins from all users using predicate
		 List<User> users = new ArrayList<User>();
		 users.add(new User("Arun","admin"));
		 users.add(new User("mala","admin"));
		 users.add(new User("guru","admin"));
		 users.add(new User("reka","user"));
		 users.add(new User("puppy","guest"));
		 users.forEach(user -> System.out.println(user));
		 
		 List<User> admins = getAdminList(users, (User u) -> u.getRole().equals("admin") ); //uses predicate
		 admins.forEach(System.out::println );
		 
		 //consumer uses accept() one input, no returns .
		 Consumer<String> display =  name -> System.out.println("Hello, " + name);
		 display.accept("John");

		// Consumer to multiply 2 to every integer of a list
	        Consumer<List<Integer> > modify = b ->
	        {
	            for (int i = 0; i < b.size(); i++)
	                b.set(i, 2 * b.get(i));
	        };

	        // Consumer to display a list of integers
	        Consumer<List<Integer> > dispList = l -> l.stream().forEach(a -> System.out.print(a + " "));
	     
	        List<Integer> l = new ArrayList<Integer>();
	        l.add(2);
	        l.add(1);
	        l.add(3);
	       
	        // using addThen()
	        modify.andThen(dispList).accept(l);
	   		 
	        // Sipplier no  input,returns  output.
	        Supplier<String> message = () -> "Welcome to Java";
            System.out.println(message.get());
            
            //method call
            String[] names = {"bala", "madhu", "reka", "amala" };
        	Arrays.stream(names).forEach(LambdaExample::print);
            
        	List<String> fruits = Arrays.asList("Banana", "Apple", "Mango");
        	fruits.sort(String::compareToIgnoreCase); // ignores case  while sorting 
        	fruits.forEach(System.out::print);
		  		 
		 
	}
	 
		 public static List<User> getAdminList(List<User> users , Predicate<User> predicate)
		 {
			 List<User> adminList = new ArrayList<User>();
			 for(User u : users )
			 {
				 if(predicate.test(u)) adminList.add(u);
			 }
			 
			 return adminList;
		 }
		 
		 public static void print(String n) 
		 {
		 System.out.println(n);
		 }
	
}


	
	class User
	{
		String name;
		String role;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public User(String name, String role) {
			super();
			this.name = name;
			this.role = role;
		}
		@Override
		public String toString() {
			return "User [name=" + name + ", role=" + role + "]";
		}
		
		
		
	}




