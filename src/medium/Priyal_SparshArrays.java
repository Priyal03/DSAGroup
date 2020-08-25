package hackerrank.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Priyal_SparshArrays {

	public static void main(String[] args) {
		int stringsCount = scanner.nextInt();
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] strings = new String[stringsCount];

		for (int i = 0; i < stringsCount; i++) {
			String stringsItem = scanner.nextLine();
			strings[i] = stringsItem;
		}

		int queriesCount = scanner.nextInt();
		 scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String[] queries = new String[queriesCount];

		for (int i = 0; i < queriesCount; i++) {
			String queriesItem = scanner.nextLine();
			queries[i] = queriesItem;
		}

		int[] res = matchingStrings(strings, queries);

		for (int i = 0; i < res.length; i++) {
			System.out.print((res[i])+" ");

		}

	}
/*
 * finding the matching strings by storing the occurrences of strings in a hashMap and 
 * then just storing the values of that hashmap for respective queries.
 * 
 * Time Complexity : O(n+n*m)
 * Space Complexity : O(n)
 * ;n=size of string array, m=size of query array
 */
	static int[] matchingStrings(String[] strings, String[] queries) {
		
		int[] a = new int[queries.length];
		if(strings.length==0 || queries.length==0) {
			return a;
		}

		Map<String, Integer> hashMap = new HashMap<>();

		for (String key : strings) {
			hashMap.computeIfPresent(key, (k, v) -> v + 1);
			hashMap.computeIfAbsent(key, v->1);
		}
		
		int i=0;
		for(String key:queries) {
			
			if(hashMap.containsKey(key)) { 
				a[i]=hashMap.get(key);
				
			}else {
				a[i]=0;
			}
			i++;
		}
		
		//good way new way
	//	a = Arrays.stream(queries).map(q->hashMap.getOrDefault(q, 0L)).map;
		
		return a;
	}

	private static final Scanner scanner = new Scanner(System.in);

}