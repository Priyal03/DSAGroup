package leetcode.sort.search;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
public class SortColors {

	public static void main(String[] args) {
		
		int arr[]=new int[] {0,1,2,0,1,2};
		sortColors(arr);
		
		onePass(arr);
	}
    private static void onePass(int[] arr) {
		
    	int start=0, end = arr.length-1, i=0;
    	while(start<end && i<=end) {
    		
    		if(arr[i]==0) {
    			arr[i]=arr[start];
    			arr[start]=0;
    			start++; i++;
    		}else if(arr[i]==2) {
    			arr[i]=arr[end];
    			arr[end]=2;
    			end--;
    		}else
    			i++;
    	}
		
	}
	public static void sortColors(int[] nums) {
        
        Map<Integer,Integer> occur = new LinkedHashMap<Integer,Integer>();
        
        occur.put(0, 0);
        occur.put(1, 0);
        occur.put(2, 0);
        
        for(int i=0;i<nums.length;i++){
            
            int key=Integer.valueOf(nums[i]);
            
            //occur.computeIfAbsent(key, v->1);
            
            occur.computeIfPresent(key,(k,v)->v+1 );
        }
       // int i=0; 
        StringBuilder sb=new StringBuilder("[");
        for(Entry<Integer, Integer> x : occur.entrySet()) {
        	
        	int val=x.getValue();
        	while(val-->0) {
        		//nums[i]=x.getKey();
        		//i++;
                sb.append(x.getKey()+",");
        		
        	}
        }
     //   sb.
        sb.replace(sb.length()-1, sb.length(), "]"); 
        System.out.print(sb.toString()); 
    }
}