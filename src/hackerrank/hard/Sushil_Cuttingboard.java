import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Collections; 

public class Solution {

    // Complete the boardCutting function below.
    static int boardCutting(int[] y, int[] x) {
        Arrays.sort(y);
        Arrays.sort(x);
        int h =1, v=1;
        int totalCost= 0;

        int i = y.length -1 , j = x.length -1;
        while(i >= 0 && j >= 0){
            if(y[i] > x[j]){
                totalCost = totalCost + y[i]*h;
                v++;
                i--;
            }else{
                totalCost = totalCost + x[j]*v;
                h++;
                j--;
            }
        }
        while (i >= 0){
            totalCost = totalCost + y[i]*h;
                v++;
                i--;
        }
        while(j>=0){
            totalCost = totalCost + x[j]*v;
                h++;
                j--;
        }

        int round = (int) (Math.pow(10,9) + 7);
        totalCost = totalCost % round;
        return totalCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] mn = scanner.nextLine().split(" ");

            int m = Integer.parseInt(mn[0]);

            int n = Integer.parseInt(mn[1]);

            int[] cost_y = new int[m-1];

            String[] cost_yItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m-1; i++) {
                int cost_yItem = Integer.parseInt(cost_yItems[i]);
                cost_y[i] = cost_yItem;
            }

            int[] cost_x = new int[n-1];

            String[] cost_xItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n-1; i++) {
                int cost_xItem = Integer.parseInt(cost_xItems[i]);
                cost_x[i] = cost_xItem;
            }

            int result = boardCutting(cost_y, cost_x);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
