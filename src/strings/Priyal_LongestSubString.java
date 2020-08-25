package leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Priyal_LongestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Priyal_LongestSubString ls = new Priyal_LongestSubString();
		int x = ls.lengthOfLongestSubstrin("pwwkew");
		
		System.out.println(x);
	}
//TC : O(n)
    private int lengthOfLongestSubstrin(String input) {
    	
    	Map<Character, Integer> map = new HashMap<>();
	    String output = "";
	    
	    for (int startIndex = 0, lastIndex = 0; lastIndex < input.length(); lastIndex++) {
	        
	    	char currChar = input.charAt(lastIndex);
	    	
	    	//need to save the last occurrence of char in hashmap
	    	if (map.containsKey(currChar)) {
	            startIndex = Math.max(map.get(currChar)+1, startIndex);
	        }
	        
	    	int currLength=lastIndex - startIndex + 1;
	    	if (output.length() < currLength) {
	            output = input.substring(startIndex, lastIndex + 1);
	        }
	        
	    	map.put(currChar, lastIndex);//storing last index of that character
	    	
	    	System.out.println(map+" "+output);
	    }
    	
      	return output.length();
	}
// TC : O(n*(n+1)/2)
    public int lengthOfLongestSubstringSet(String input) {
       String output = "";
       
       for (int start = 0; start < input.length(); start++) {
           
    	   Set<Character> visited = new HashSet<>();
           int end = start;
           
           for (; end < input.length(); end++) {
               
        	   char currChar = input.charAt(end);
               
        	   if (visited.contains(currChar)) {
                   break;
               } else {
                   visited.add(currChar);
               }
           }
          
           if (output.length() < end - start + 1) {
               output = input.substring(start, end);
           }
       }
       return output.length();   
    }
    
    public int lengthOfLongestSubstring(String s) {
        int size=0, max=0,n=s.length(), oneOccur=0;
        
       char[] ch= s.toCharArray();
       int[] bits=new int[256];// a to z 0...5 a 0 b 1 c 3... z 25 pwwkew  ar[17]=0; 1
     //  w arr[22]++ =2 +! +1 +1
       boolean flag=false;
       while(n-->0) {
    	   
    	   bits[ch[n]]++;
    	   size++;
    	  //3
    	   
    	   if(bits[ch[n]]>1) {//why ? repeating .. 
    		   size--;
    		   if(max<size)
        		   max=size;//2 
    		   size=0;
    		   bits=new int[256];
    		   flag=true;
    	   }
    	   if(oneOccur<size)
    		   oneOccur=size;
       }
    	
       if(oneOccur>max)
    	   max=oneOccur;
    	return max;
        
    }
}