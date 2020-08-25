package leetcode.contest.august9;

import java.util.Arrays;

public class NonOverlappingK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { 1, 2, 1, 2, 6, 7, 5, 1 };

		NonOverlappingK obj = new NonOverlappingK();

		int x[] = obj.maxSumOfThreeSubarrays(nums, 2);

		// System.out.println(y);

		Arrays.stream(x).forEach(System.out::println);
	}

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {

		int n = nums.length;

		int[] kWindowSum = new int[n], res = new int[3];

		int sum = 0;
		for (int i = n - 1; i >= 0; i--) {

			if (i >= n - k) {

				sum += nums[i];
				if (i == n - k) {
					kWindowSum[i] = sum;
				}
			} else {

				sum += nums[i];
				sum -= nums[i + k];
				kWindowSum[i] = sum;
			}
		}
//prep prefixsum.
//spac is n+k.
//time is n*n.
		int maxSum = 0;
		for (int j = k; j <= n - 2 * k; j++) {//because leaving buffer of k lengths.

			int sum2 = kWindowSum[j], sum1 = 0, idx1 = 0, sum3 = 0, idx3 = 0;

			for (int i = 0; i <= j - k; i++) { //2nd index
				if (kWindowSum[i] > sum1) {
					sum1 = kWindowSum[i];
					idx1 = i;
				}
			}

			for (int l = j + k; l <= n - k; l++) {//3rd index
				if (kWindowSum[l] > sum3) {
					sum3 = kWindowSum[l];
					idx3 = l;
				}
			}

			if (sum1 + sum2 + sum3 > maxSum) {
				maxSum = sum1 + sum2 + sum3;
				res[0] = idx1;
				res[1] = j;
				res[2] = idx3;
			}
		}
		return res;
	}
//		int sum = 0, fsum = 0,max=0, i = 0;
//		int b[]=new int[3];
//		for (int m = 0; m < n; m++) {
//			
//			while (i < n) {
//				
//				sum = a[i];
//				
//				for (int j = i + 1; j < k + i; j++) {
//					sum += a[j];
//				}
//				
//				fsum = Math.max(fsum, sum);
//				System.out.println(fsum + " yaha at " + sum);
//				i = i + k;
//			}
//			
//		}
//		return max;

	int maxSumMnonOverlappingSubarray(int presum[], int m, int size, int k, int start) {
// if m is zero then no need  
// any array of any size so 
// return 0. 
		if (m == 0)
			return 0;

// if start is greater then the  
// size of presum array return 0. 
		if (start > size - 1)
			return 0;

		int mx = 0;

// if including subarray of size k 
		int includeMax = presum[start] + maxSumMnonOverlappingSubarray(presum, m - 1, size, k, start + k);

// if excluding element and searching  
// in all next possible subarrays 
		int excludeMax = maxSumMnonOverlappingSubarray(presum, m, size, k, start + 1);

// return max 
		return Math.max(includeMax, excludeMax);
	}

	void calculatePresumArray(int presum[], int arr[], int n, int k) {
		for (int i = 0; i < k; i++)
			presum[0] += arr[i];

// store sum of array index i to i+k  
// in presum array at index i of it. 
		for (int i = 1; i <= n - k; i++)
			presum[i] += presum[i - 1] + arr[i + k - 1] - arr[i - 1];
	}

	
}
