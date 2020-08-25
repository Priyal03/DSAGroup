package hackerrank.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;
/**
 * The idea is to sort the array into reverse order and then do the calculations;
 * instead I could have just started with max exponent, so now I've added one more variant(marcsCake method) as well.
 * TC: O(n)
 * SC:(1)
 */
public class Priyal_MarcsCakewalk {

	// Complete the marcsCakewalk function below.
	static long marcsCakewalk(int[] calorie) {

		long sum = 0;
		double i=0;
		
		
		Integer[] nR = IntStream.of(calorie).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

		for(int x:nR) {
			
			sum += x * Math.pow(2, i); 
			i++;
		}
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = scanner.nextInt();

		int[] calorie = new int[n];

		for (int i = 0; i < n; i++) {
			
			calorie[i] = scanner.nextInt();
		}

		long result = marcsCake(calorie);

		System.out.println(result);
		scanner.close();
	}

	private static long marcsCake(int[] calorie) {
		// TODO Auto-generated method stub
		
		Arrays.sort(calorie);
		
		long sum=0;
		int j=calorie.length;
		
		for(int i=0;i<j;i++) 
			sum+=calorie[i]*Math.pow(2, --j);
		
		return sum;
	}
	
	public void quickSort(int arr[]) {
		
	}
}
