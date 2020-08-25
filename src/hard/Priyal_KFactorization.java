package hackerrank.hard;
/**
 * 72 9
2 3 4 5 6 7 9 10 16

9 8 allfactors (4 2 ) 1 2 8 72
6 12 allfactors (1 2 3 4 6 12) 1 3 12 72
 * 
 *
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Priyal_KFactorization {

	static int index = 0;
	static Stack<Integer> stack;

	// Complete the kFactorization function below.
	static int[] kFactorization(int n, int[] arr) {

		Arrays.sort(arr);
		int size = 0, min = Integer.MAX_VALUE;
		 Stack<Integer> stack2 = null;
		for (int i = 0; i < arr.length; i++) {
			
			index = arr.length;
			stack = new Stack<Integer>();
			findSeries(n, arr);
			size = stack.size();
			
		}
	//	stack.stream().forEach(System.out::println);
		size=stack.size();
		int a[] = new int[size + 1];
		int i = 0;
		if (size == 0) {
			a = new int[1];
			a[0] = -1;
		} else {
			stack.add(1);
		}
		while (!stack.isEmpty()) {
			a[i] = stack.pop();
			i++;
		}

		return a;
	}

	private static void findSeries(int n, int[] arr) {

		index--;
		if (n == 1 || index < 0) {
			return;
		}
		if (n % arr[index] == 0) {

			stack.add(n);
			n = n / arr[index];
		}
		findSeries(n, arr);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] A = new int[k];

		String[] AItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < k; i++) {
			int AItem = Integer.parseInt(AItems[i]);
			A[i] = AItem;
		}

		int[] result = kFactorization(n, A);

		for (int i = 0; i < result.length; i++) {

			System.out.print(result[i]);

			if (i != result.length - 1) {
				System.out.print(" ");
			}
		}
		scanner.close();
	}
}
