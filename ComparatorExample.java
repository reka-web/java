package com.example.collections;

import java.util.*;

class Student
{
	String name;
	int age;
	String course;
	public Student(String name, int age, String course) {
		super();
		this.name = name;
		this.age = age;
		this.course = course;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n"  + name + "  :  " + age + "  :  " + course ;
	}
	
	
}

public class ComparatorExample 
{
	public static void main(String[] args)
	{
		Student s1= new Student("Gunal",25,"Java");
		Student s2 = new Student("Arun", 39, "Phyton");
		Student s3= new Student("Arun", 20, "C,C++");
		Student s4= new Student("Bheem",35,"DataSciense");
		Student s5 = new Student("Chandru", 19, "MainFrame");
		Student s6= new Student("Zion", 40, "AI");
		
		List<Student> students = new ArrayList<>();
		students.add(s1);students.add(s2);students.add(s3);
		students.add(s4);students.add(s5);students.add(s6);
		System.out.println(students);
		
		students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));	
		System.out.println(students);
		
		Collections.reverse(students);	System.out.println(students);
	}

}
