package com.example.math;

import java.util.*;


public class GuessNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		guessNum();

	}

	public static void guessNum()
	{

        int number = (int) ((Math.random()*100) + 1) ;
        Scanner sc = new Scanner(System.in);
        int trial = 5;
        int guess;
        
        System.out.println("Number 1 to 100 is taken. Guess the number!");
        
        for(int i=0; i<trial ; i++)
        {
        	guess = sc.nextInt();
        	if(guess == number) 
        	{
        		System.out.println(" your guess is right !");
        		sc.close();
        		return;
        	}
        	else if( guess < number)
        	   System.out.println("The number is greater than " + guess);			
          	else
        		 System.out.println("The number is less than " + guess);
       }
        System.out.println(" Number of attempts is over.The number is " + number); 
        sc.close();
        return;

	}
	
}


