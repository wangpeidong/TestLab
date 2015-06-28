package org.testlab;

import java.util.Optional;

public class FizzBuzzInJava8 {

	public static String fizzBuzz(final int number)
	{
		String result = Optional.of(number).map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : "")).get();
		return result.isEmpty() ? String.valueOf(number) : result;
		
	}
	
	public static void main(String[] args) {
		System.out.println("FizzBuzz solution using Java 8 : " + fizzBuzz(15));
		System.out.println("FizzBuzz solution using Java 8 : " + fizzBuzz(3));
		System.out.println("FizzBuzz solution using Java 8 : " + fizzBuzz(5));
		System.out.println("FizzBuzz solution using Java 8 : " + fizzBuzz(2));
	}

}
