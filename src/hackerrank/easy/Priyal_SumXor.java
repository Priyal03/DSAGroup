package hackerrank.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Priyal_SumXor {

//sum is nothing but xor op with carry
//so till xor , both the results will be same; but we need to find occurances of diff result.
//if carry==1 then they are diff means carry==0 is true condition.
//4 testcases are not passsing due to TLE.
//TC:O(n)
	static long sumXorOne(long n) {
		long and = 1, count = 0;
		if (n == 0)
			return 1;

		for (int i = 0; i < n; i++) {

			and = i & n;
			if (and == 0)
				count++;
		}
		return count;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = sumXorTwo(n);
		bufferedReader.close();
		System.out.println(result);
	}
	
//found out from online resources that if we do divide by two after each iterations 
//	while finding the carry==0
//at last, for each values of x={0,1} the total count can be 2 raise to count.
//TC:O(logn)
	private static long sumXorTwo(long n) {
		
		long carry = 1, count = 0;
		
		if (n == 0)
			return 1;

		while(n>0) {

			carry = 1 & n;// for n=1 the carry will result in 1 and thus a carry is present in add operation, hence false result for sum vs xor
			if (carry == 0)//(possible values of n={0},
				count++;
			
			n=n>>1;
		}
		return 1<<count;
	}
}