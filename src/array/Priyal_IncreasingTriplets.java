package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class Priyal_IncreasingTriplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,-1,-1,-1,3 };

		System.out.println(increasingTriplet(arr));
	}

	private static void findTriplets(int[] arr) {
		// TODO Auto-generated method stub

		int small = Integer.MIN_VALUE, j=1, smaller = Integer.MIN_VALUE, smallest = Integer.MIN_VALUE, n = arr.length;

		int smallArr[] = new int[n];
		boolean flag = false;
		smallArr[0]=-1; 
		for (int i = 0; i < n-3; i++) {

			if( smallArr[j-1]>arr[i]) {
				smallArr[j]=arr[i];
				j++;
			}
			
		}
		for (int i = 0; i < n; i++) {
			 if ((smaller == Integer.MIN_VALUE || smaller > arr[i]) && arr[i] > small && i<n-2) {
				smaller = arr[i];
				smallest = Integer.MIN_VALUE;
			}

			else if (smallest == Integer.MIN_VALUE && arr[i] > smaller && smaller!=smallest) {
				smallest = arr[i];
			}


			System.out.println(small+" "+smaller+" "+smallest+" attt "+i);
			if (small > Integer.MIN_VALUE && smaller > small && smallest > smaller) {
				System.out.println(small+" "+smaller+" "+smallest);
				flag = true;
				break;
			}
		}
		if (flag)
			System.out.println(true);
	}
/**
 * Except two test-cases, this will do just fine.
 * O(n)
 * O(1)
 */
	
	public boolean increasingTrip(int[] arr) {
        
		int small=Integer.MIN_VALUE,smaller=Integer.MIN_VALUE,smallest=Integer.MIN_VALUE, n=arr.length;
		
		int in[]=new int[3];
		boolean flag=false;
		ArrayList<Integer>  list[] = new ArrayList[n];
		
		for(int i=0;i<n;i++) {
			
			if(small==Integer.MIN_VALUE || small>arr[i]) {//
				small=arr[i];
				smaller=Integer.MIN_VALUE;
				smallest=Integer.MIN_VALUE;
			}
			
			else if((smaller==Integer.MIN_VALUE || smaller>arr[i]) && arr[i]>small) {
				smaller=arr[i];
                smallest=Integer.MIN_VALUE;
			}
			
			else if (smallest == Integer.MIN_VALUE && arr[i] > smaller && smaller!=smallest) {
				smallest = arr[i];
			}
			if(small>Integer.MIN_VALUE && smaller>small && smallest >smaller) {
				
				flag=true;
				break;
			}
		}
		if(flag)
			return true;
        else
            return false;
	
    }
	/*
	 * 
	 */
	public static boolean increasingTriplet(int[] arr) {
       
		int small=Integer.MAX_VALUE,smaller=Integer.MAX_VALUE, smallest=0,min=0,max=0,n=arr.length, count=0;
		boolean flag=false;
		
		for(int i=0;i<n;i++) {
			
			if( small>arr[i]) {
				
				small=arr[i];
				if(count==0) {
					min=small;
					count++;
				}
			}else { 
				
				if(count==2 && arr[i]>smaller) {
					smallest=arr[i];
					flag=true;
					break;
				}
				else if( arr[i] > small && arr[i]<smaller) {
					smaller = arr[i];
					if(count==1) {
						max=smaller;
						count++;
					}
				}
			}
		}
		System.out.println(min+" "+max+" "+smallest+" attt ");
		if(flag)
			return true;
        else
            return false;
    }
}
