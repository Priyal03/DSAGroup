import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long[] candiesLeft = new long[n];
        long[] candiesRight = new long[n];
        candiesLeft[0] =1;
        candiesRight[n-1] =1;
        long sum = 0L;

        for(int i =1; i<n ; i++){
            if(arr[i] > arr[i-1]){
                candiesLeft[i] = candiesLeft[i-1] + 1;
            }else{
                candiesLeft[i] = 1;
            }
        }
        
        for(int i = n-2 ; i >= 0 ; i--){
            if(arr[i] <= arr[i+1]){
                candiesRight[i] = 1;
            }else{
                candiesRight[i] = candiesRight[i+1] +1;
            }
        }

        for(int i =0 ; i<n ; i++){
           sum += Math.max(candiesRight[i], candiesLeft[i]);
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
