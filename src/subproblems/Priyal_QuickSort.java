package subproblems;

public class Priyal_QuickSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {3,6,42,6,2,8,9};
		
		quick(arr,0,arr.length-1);
		
		for(int x:arr) {
			System.err.println(x);
		}
	}
	private static void quickDescending(int[] arr, int s, int n) {
		
		if(s>=n)
			return;
		
		int  pivot=arr[n], highPointer=s;
		
		for(int i=s;i<n;i++) {
			
			if(arr[i]>pivot) {
				swap(arr,i,highPointer);
				highPointer++;
			}
			
		}
		swap(arr,highPointer,n);
		quickDescending(arr,s, highPointer-1);
		quickDescending(arr,highPointer+1,n);
		
	}
	private static void quick(int[] arr,int s, int n) {
		
		if(s==n || s>n)
			return;
		
		int pivot=arr[n], lowPointer=s;
//take the pivot element and in accordance to that set the swapping pointer.
//Keep increasing the pointer after each swap so that we reach the right loc for pivot element.		
		
		for(int i=s;i<n;i++) {
			
			if(arr[i]<=pivot) {
				
				swap(arr,i,lowPointer);//swapping the lower elements will stack them up on left side.
				
				lowPointer++;
				
			}
		}
		//at last attach the pivot in left subarray
			swap(arr, n,lowPointer);
		
		
		quick(arr,s, lowPointer-1);
		quick(arr,lowPointer+1,n);
		
	
	}
	private static void swap(int[] arr, int i, int j) {
		if(i==j)
			return;
		
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
/**
 * Idea is to take a pivot the divide the array into smaller and larger than that element
 */
	
}
