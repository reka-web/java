package com.example.regex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String[] args)
	
	{
		//patteren class
		
		System.out.println(Pattern.matches("hello[1-9]", "hello123")); //false
        System.out.println(Pattern.matches("java.*", "java is great")); // true
        
        Pattern p = Pattern.compile("circle");
        Matcher m = p.matcher("circle inside another circle");  
        
        StringBuffer sb = new StringBuffer();
        while(m.find()) 
        	{
        	System.out.println("from " + m.start()  + "   to " + m.end());
        	System.out.println(m.group());
        	
        	m.appendReplacement(sb, "CIRCLE");
        	
        	}
        m.appendTail(sb);
        System.out.println(sb.toString());
        
        System.out.println(m.replaceAll("Java"));
        

        String in = "1234";
        System.out.println(in.matches("[1-9]*")); //true
        
        in = "Allexa";
        System.out.println(in.matches("[A-Z]")); //false
        System.out.println(in.matches("[^0-9].*")); //true
        
        
        in = "0007";
        System.out.println(in.matches("0*\\d")); //false
	}

}
