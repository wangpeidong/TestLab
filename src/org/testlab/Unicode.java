package org.testlab;

/**
 * Program to test unicode which Java supports natively.
 * 
 * @author Wang Peidong
 *
 */
public class Unicode {
	// Launcher
	public static void main(String[] args) {
		long numeric = 123_456_789;
		float \u03c0 = 3.14159F;
		System.out.println("numeric=" + numeric);
		System.out.println("\u03c0=" + \u03c0);
	}

}
