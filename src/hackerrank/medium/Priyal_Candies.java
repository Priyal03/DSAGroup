package hackerrank.medium;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Priyal_Candies {

	// Complete the candies function below.
	static long candies(int numberOfStudents, int[] ratings) {

		int len = ratings.length, total = 0;

		int candies[] = new int[len];

		for (int i = 0; i < len; i++) {

			candies[i] = 1; // giving atleaset one candy to each
		}

		for (int i = 0; i < len - 1; i++) {
			if (ratings[i] < ratings[i + 1]) {

				candies[i + 1] = candies[i] + 1; // giving one more to the next student who has higher rating
			}
		}

		int curr, prev;
		for (int i = len - 1; i > 0; i--) {

			if (ratings[i - 1] > ratings[i]) {

				curr = candies[i] + 1;
				prev = candies[i - 1];

				if (curr > prev) {
					candies[i - 1] = curr;
				}
			}
		}

		for (int i = 0; i < numberOfStudents; i++) {
			total += candies[i];
		}

		return total;
	}

	// make use of series summation formula

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int n = 10;

		int[] arr = { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 };

		long result = optimalCandies(n, arr);

		System.out.println(result);
		scanner.close();
	}
/**
 * 
 * @param numberOfStudents
 * @param ratings
 * @return
 * 
 * diving in subarrays with highs and lows
 * that's nothing but series from 1 to n ==> do the series summation
 * keep track of the sum in hashmap (that will avoid doing same calculations again n again)
 * at last just add the values of hashmap for getting the total number of candies.
 */
	private static long optimalCandies(int numberOfStudents, int[] ratings) {

		int len = ratings.length;
		long sum = 0; 

		Map<Integer, Integer> hashMap = new HashMap<>();//map is storing the length of series. 
//		int[] arr = { 2, 4, 2, 6, 1, 7, 8, 9, 2, 1 }; 
		//2,2,4,2 
		
		int sizeOfSubarray = 1, i = 1; //i is the index for accessing ratings of each student
		int prev = ratings[0];
		while (i < len) {

			boolean isIncreasing = false, isDecreasing = false, isEquals=false;
			sizeOfSubarray = 1;
			
			 while (i < len && ratings[i] > prev) {
				prev = ratings[i];
				i++;
				sizeOfSubarray++;
				isIncreasing = true;
			}

			if (isIncreasing) {
			//	j++;
				int one = (sizeOfSubarray * (sizeOfSubarray + 1) / 2);//series summation formula for 1 to n numbers
				hashMap.computeIfPresent(sizeOfSubarray, (k, v) -> v + one);
				hashMap.computeIfAbsent(sizeOfSubarray, v -> one);
				
		//		System.out.println(sum+" at "+j+" with "+hashMap.get(j));
				
				if(i<len)
					prev = ratings[i];
		//		System.out.println(i+" IN "+prev);
			}
			
			sizeOfSubarray = 1;
			while (i < len && ratings[i] < prev) {
				prev = ratings[i];
				i++;
				sizeOfSubarray++;
				isDecreasing = true;
			}

			if (isDecreasing) {
				//j++;
				int one = (sizeOfSubarray * (sizeOfSubarray + 1) / 2);//series summation formula for 1 to n numbers
				hashMap.computeIfPresent(sizeOfSubarray, (k, v) -> v + one);
				hashMap.computeIfAbsent(sizeOfSubarray, v -> one);
		//		System.out.println(" at "+j+" with "+hashMap.get(j));
				if(i<len)
					prev = ratings[i];
				
		//		System.out.println(i+" DE "+prev);
				//i++;
			}

			sizeOfSubarray=1;
			
			while(++i<len && prev==ratings[i]) {
				
				i++;
				sizeOfSubarray++;
				isEquals=true;
				
			//	System.out.println(i+" EQ "+prev);
			}
			if(isEquals) {
				
				//consider a case when u have 9 9 9 9 9 student ratings
				//I will give candies in following manner: 1+2+1+2+1 :so that can be done by size+size/2
				sum+=sizeOfSubarray+sizeOfSubarray/2;
				
			}
			
		//	System.out.println(sum+" at "+i);
			
			if (!isIncreasing && !isDecreasing && !isEquals) {
				i++;
			}
			
			if(i==len) {
				sum++;
			}
			
		}

		Set<Integer> keys = hashMap.keySet();

		for (int key : keys) {
			
			sum += hashMap.get(key);
		//	System.out.println(sum+" at "+key+" with "+hashMap.get(key));
		}
		
		return sum;
	}
}
