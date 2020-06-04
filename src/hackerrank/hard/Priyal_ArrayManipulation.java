package hackerrank.hard;

import java.util.Scanner;

/*
 * make use of prefix sum algorithm & difference array problem.
 * Time Complexity : O(m+n)
 * Space Complexity : O(n+1)
 */
public class Priyal_ArrayManipulation {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();

		int m = scanner.nextInt();

		long[] arr = new long[n + 1]; // array size + the one space for end+1 calculations.

		while (m-- > 0) { // doing it for m number of queries.

			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int value = scanner.nextInt();

			arr[start - 1] += value; // according to diffArray incrementing the value at start index
			arr[end] -= value; // and decrementing the value at end+1 index
		}

		long result = 0, sum = 0;

		for (long curr : arr) {//at last just take the prefix sum of all elements in the array and we will get the max val.
			
			sum += curr;
			result = Math.max(result, sum);
			// System.out.println(curr);
		}

		System.out.println(result);
	}
}