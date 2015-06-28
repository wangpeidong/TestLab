package org.testlab;

import java.util.*;

public class Java8Lambda {

	public static void main(String[] args) {
		new Thread(() -> System.out.println(Thread.currentThread().getName() + " - In Java8 Lambda expression rocks"))
				.start();

		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		// features.forEach(n -> System.out.println(n));
		features.forEach(System.out::println);

		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map(cost -> cost + 0.12 * cost).forEach(System.out::println);
		System.out.println("Total: "
				+ costBeforeTax.stream().map(cost -> cost + 0.12 * cost).reduce((sum, cst) -> sum + cst).get());

	}

}
