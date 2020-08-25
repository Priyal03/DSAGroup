package leetcode.contest.august9;

import java.util.*;

class Sushil_NonOverlappingSubArray {
	   public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
	      // List<Integer> list = new ArrayList<>();
	      // Map<Integer, Integer> map = new HashMap<>();
	       Map<Integer,Integer> map=new TreeMap<Integer,Integer>(Collections.reverseOrder());//sum,index
	       int[] finalArr = new int[3];
	       int i=0,j=k,sum=0;
	       
	       while(i<=j && j<=nums.length){
	           sum = sum + nums[i];
	           if(i == j-1){
	               j=j+k;
	               if(map.containsKey(sum)){
	                   map.put(sum, Math.min(map.get(sum) , j-k));
	               }else{
	                   map.put(sum, j-k);
	               }
	               sum=0;
	           }
	           i++;
	       }
	       
	       int a=0;
	       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {  // Itrate through hashmap
	           if (a<3) {
	               finalArr[a] = entry.getKey();
	               a++;
	               // Print the key with max value
	           }
	       }
	       return finalArr;
	   }
	}