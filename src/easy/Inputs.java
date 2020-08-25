package hackerrank.easy;

import java.util.Scanner;

public class Inputs {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();

        sc.skip("\n");
       
        for(int j=0;j<n;j++) {

            String curr = sc.nextLine();
            
            char[] charArray = curr.toCharArray();
            
            StringBuilder sbEven=new StringBuilder();
            StringBuilder sbOdd=new StringBuilder();
            
            for(int i=0;i<curr.length();i++) {
            	
            	if(i%2==0) {
            		sbEven.append(charArray[i]);
            	}else {
            		sbOdd.append(charArray[i]);
            	}
            }

            System.out.println(sbEven.toString()+" "+sbOdd.toString());
        }
    }
}