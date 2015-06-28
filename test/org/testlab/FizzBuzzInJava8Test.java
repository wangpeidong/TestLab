package org.testlab;

import static org.junit.Assert.*;

import org.junit.Test;

public class FizzBuzzInJava8Test {

	@Test
	public void testWithIntegerDividableBy15() {
		assertEquals("FizzBuzz", FizzBuzzInJava8.fizzBuzz(15));
		assertEquals("FizzBuzz", FizzBuzzInJava8.fizzBuzz(30));
		assertEquals("FizzBuzz", FizzBuzzInJava8.fizzBuzz(45));
	}
	
	@Test
	public void testWithIntegerDividableBy3() {
		assertEquals("Fizz", FizzBuzzInJava8.fizzBuzz(3));
		assertEquals("Fizz", FizzBuzzInJava8.fizzBuzz(6));
		assertEquals("Fizz", FizzBuzzInJava8.fizzBuzz(9));
	}

	@Test
	public void testWithIntegerDividableBy5() {
		assertEquals("Buzz", FizzBuzzInJava8.fizzBuzz(5));
		assertEquals("Buzz", FizzBuzzInJava8.fizzBuzz(10));
		assertEquals("Buzz", FizzBuzzInJava8.fizzBuzz(20));
	}

	@Test
	public void testOtherInteger() {
		assertEquals("1", FizzBuzzInJava8.fizzBuzz(1));
		assertEquals("2", FizzBuzzInJava8.fizzBuzz(2));
		assertEquals("7", FizzBuzzInJava8.fizzBuzz(7));
	}

}
