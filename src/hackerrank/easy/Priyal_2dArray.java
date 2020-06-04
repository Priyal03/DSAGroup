package hackerrank.easy;

import java.util.Scanner;

/**
 * @author Priyal
 * 
 */
public class Priyal_2dArray {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 6; j++) {

            	int arrItem = scanner.nextInt();
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);
	}
/*
 * Keep iterating the 2D array in 4*4 matrix, calculate sum, make sure to take max at each step and at last 
 * get the maximum hourglass sum
 * 
 * Time Complexity : O(n^n)
 * Space Complexity : O(1)
 */
	private static int hourglassSum(int[][] arr) {
		
		int max=Integer.MIN_VALUE,sum=0;
		for (int i = 1; i < 5; i++) {
			
			for (int j = 1; j < 5; j++) {
				
				sum=arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]+
						arr[i][j]+
						arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
				
				if(sum>max)
					max=sum;
			}
		}
		return max;
	}
}
