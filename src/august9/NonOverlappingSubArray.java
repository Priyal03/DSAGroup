package leetcode.contest.august9;

import java.util.HashMap;

public class NonOverlappingSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = { -1, 3, 5, 1, 4, 2, -9 };

		NonOverlappingSubArray obj = new NonOverlappingSubArray();

		int x = obj.maxNonOverlappingS(nums, 6);

		System.out.println(x);
	}

	public int solution(int nums[], int target) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		map.put(0, 0);

		int prev = 0;
		int prefixSum = 0;

		for (int i = 0; i < nums.length; ++i) {
			
			prefixSum += nums[i];
			
			int diff = prefixSum - target;
			
			if (map.containsKey(diff)) {
				
				int currKey = map.get(prefixSum - target);
				
				prev = Math.max(prev, currKey + 1);
			}
			
			map.put(prefixSum, prev);
		}

		return prev;
	}

	public int maxNonOverlappingS(int[] nums, int target) {
		int i = 0, j = 0;
		int sum = 0;
		int count = 0;
		while (i >= j) {
			if (sum < target && i < nums.length) {
				sum += nums[i];
				i++;
			} else if (sum > target) {
				sum = sum - nums[j];
				j++;
			} else if (sum == target && i <= nums.length) {
				count++;
				if (i == j) {
					i++;
				}
				j = i;
				sum = 0;
			} else {
				return count;
			}
		}
		return count;
	}

	public int maxNonOverlapping(int[] nums, int target) {

		HashMap<Integer, Integer> counts = new HashMap<>();// length, startIndex
		int i = 0, n = nums.length;
		int laps[] = new int[n];

		while (i < n) {
			if (nums[i] + nums[i + 1] == target) {
				counts.put(2, i);
				i = i + 2;
				laps[i] = 1;
				laps[i + 1] = 1;
			} else {
				i++;
			}
		}

		i = 0;

		while (i < n) {

			if (nums[i] + nums[i + 1] + nums[i + 2] == target) {

				counts.put(3, i);

				if (laps[i] == 0)
					laps[i] = 1;
				else {
					i = i + 3;
					break;
				}

				if (laps[i + 1] == 0)
					laps[i + 1] = 1;
				else {
					i = i + 2;
					break;
				}

				if (laps[i + 2] == 0)
					laps[i + 2] = 1;
				else {
					i = i + 1;
					break;
				}

			} else
				i++;
		}

		return 0;
	}
}
