package org.testlab;

public class LambdaExpression {

	public static void main(final String[] args) {
		new Thread(() -> System.out.println("Lambda Expression runnable")).start();
	}

}
