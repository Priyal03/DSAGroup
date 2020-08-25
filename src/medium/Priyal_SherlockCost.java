package hackerrank.medium;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Priyal_SherlockCost {

//b array
//	b[i]== ith position == possbile. 1 to b[i]
    // Complete the cost function below.
    static int cost(int[] arr) {

        int len=arr.length;
        
        List<List<Integer>> possibleAtIndex = new ArrayList<List<Integer>>(len);

        for(int i=0;i<len;i++){

            int j=0;
            while(arr[i]-->0){
                 
                 if(j==0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(arr[i]);
                    possibleAtIndex.add(list);
                 }else
                    possibleAtIndex.get(i).add(arr[i]);
                j++;
            }
            
        }
    for(int i=0;i<len;i++){

    List<Integer> now = possibleAtIndex.get(i);
    int j=0;
    for(int x:now){

        System.out.println(x+" at "+i+" "+j);
        j++;
    }
}
        return 0;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = findCost(B);

            System.out.println(result);
        }

        scanner.close();
    }
//array B is given, now array A will come to exist from 1 to b[i] values
//once array A has 
	private static int findCost(int[] b) {
		// TODO Auto-generated method stub
		
		int a[]=b, n=b.length;
		
		 for (int i = 0; i < n; i++) {
			 
			 a[i]=b[i]; //either .. or
			 a[i]=1;
		 }
	//	costUtil(a);
		return 0;
	}
}
