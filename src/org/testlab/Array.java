package org.testlab;

public class Array {
	@SuppressWarnings("all")
	public static void main(String[] args) {
		int[] arr1[] = new int[2][2];
		//int arr2[3] = {1, 2, 3};
		int arr2[] = {1, 2, 3};
		//int arr3[] = new int[];
		
		StringBuffer buffer1 = new StringBuffer("ABCD");
		buffer1.reverse(); // DBCA
		buffer1.replace(1, 3, "A"); // DAA
		buffer1.reverse(); // AAD
		buffer1.replace(1, 3, "A"); // AA
		System.out.println(buffer1);
		
	}
}
