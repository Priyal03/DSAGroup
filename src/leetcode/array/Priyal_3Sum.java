package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Priyal_3Sum {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num[] = { 3, 0, -2, -1, 1, 2 };
		
		byte a[]= {65,66,67,68,69,70};
		
		byte b[]= {71,72,73,74,75,76};
		
		System.arraycopy(a, 2, b, 1, a.length-3);//(a, b, a.length);
		
		System.out.println(new String(a)+"  "+new String(b));
//		List<List<Integer>> res = threeSumMy(num);
//
//		Iterator<List<Integer>> it = res.iterator();
//		
//		Stack<Integer> s= new Stack<Integer>();
//		
//s.push(10);
//		String name = "eat";
//
//		Arrays.sort(name.toCharArray());
//
//		while (it.hasNext()) {
//
//			System.out.println(it.next());
//		}
	}

	
    
  //  List<List<Integer>> res=new ArrayList<List<Integer>>();
    public static List<List<Integer>> threeSumMy(int[] num) {
        Arrays.sort(num);
        int i=0,j=num.length-1;
        checkSum(num,i,j);
       
       return res; 
    }
    public static void checkSum(int[] num,int i,int j){
        
        if(i>num.length-2 || j<1 || i>j || num.length<3)
            return; 
        
        
        if(num[i]+num[i+1]+num[j]==0){
            List<Integer> list = new ArrayList<Integer>();
            list.add(num[i]);
            list.add(num[i+1]);
            list.add(num[j]);
//             if(list.get(0)==0 && list.get(1)==0 && list.get(2)==0 ) {
                
//             }else {
                
            	Collections.sort(list);
            	if(!res.contains(list) && !list.isEmpty() )
                    res.add(list);  
                    
            
        }else if(num[i]+num[j-1]+num[j]==0){
            List<Integer> list = new ArrayList<Integer>();
            list.add(num[i]);
            list.add(num[j-1]);
            list.add(num[j]);
//             if(list.get(0)==0 && list.get(1)==0 && list.get(2)==0 ) {
                
//             }else {
                
            	Collections.sort(list);
            	if(!res.contains(list) && !list.isEmpty() )
                    res.add(list);  
            
        }
        checkSum(num,i+1,j);
        checkSum(num,i,j-1); 
    }
}

//Refer next time.


//public static List<List<Integer>> threeSum(int[] num) {
//	
//	Arrays.sort(num);
//
//	int low = 0, high = num.length - 1;
//	int n = num.length;
//
//	if (high < 2 || num[high] < 0) {
//		return res;
//	}
//	int k = 0;
//
//	while (k < n - 2) {
//
//		if (num[k] > 0)
//			break;
//
//		int curr = num[k];
//
//		low = k + 1;
//		while (low < high) {
//			if (num[high] < 0)
//				break;
//
//			int sum = num[low] + num[high] + curr;
//			if (sum == 0) {
//				
//				res.add(Arrays.asList(num[k], num[low], num[high]));
//				while (low < high && num[low] == num[++low]); //3, 0, -2, -1, 1, 2 ,2,3
//				while (low < high && num[high] == num[--high]);
//				
//			} else if (sum > 0) {
//				high--;
//			} else {
//				low++;
//			}
//		}
//		while (k < n - 2 && num[k] == num[++k]);
//	}
//
//	return res;
//}
//
