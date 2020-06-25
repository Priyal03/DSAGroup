package leetcode.strings;

import java.util.HashMap;
/*
 * Can't emphasis more on starting with brute force and then optimizing it.
 * later store the length in map to avoid more calculations.
 * 
 * TC : O(n^2*(n/2))
 * SC : O(n^2)
 */
public class Priyal_LongestPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="Java 8,						RESTful web-services,";
				
		 String arr[]=s.split(", ");
		 
		 StringBuilder sb=new StringBuilder();
		 
		 for(String now:arr) {
			// System.out.println(now);
			 sb.append(now+",\t");
		 }
		
		 
		 int mask = 0x000F;
	        int value = 0x2222;
	        System.out.println(value & mask);
	        
//		String  sa= longestPalindrome(s);
//		
//		System.out.println(sa);
	}

	public static String longestPalindrome(String s) {
        
        int size=0, max=-1,n=s.length(),length=0;
        
        if(n==1)
            return s;
       
        String sub="",fsub="";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        HashMap<Integer, String> map2 = new HashMap<>();
        
        for(int i=0;i<n-1;i++) {
       	 
            for(int j=i;j<n;j++){
                
                sub=s.substring(i,j+1);
                
            	size=sub.length();
               
               if(!map2.containsKey(length)) {
            	  if( isPalindrom(sub)) {
            		  map2.put(size, sub);
            		  if( size>max){
                          max=size;
                          fsub=sub;
                      }
            	  }
               }
                
//                if(!map.containsKey(sub)) {
//                	size=isPalindrome(sub);
//                	
//                	map.put(sub, size);
//                
//                if( size>max){
//                    max=size;
//                    fsub=sub;
//                }
//                }
              //  System.out.println(max+"  at "+fsub+" "+j);
            }
        }
        System.out.println(max+" "+fsub);
        return fsub;
    }

	private static boolean isPalindrom(String s) {
		
		 boolean flag=false;
		 int n=s.length(),i=0,j=n-1;
		 if(n==1)
			 return true;
		while(i<=j) {  
	         if(s.charAt(i)==s.charAt(j))
	        	 flag=true;
	         else {
	        	 flag=false;
	        	 break;
	         }
	         i++;
	         j--;
		}
	     return flag;
	}
	
	
	private static boolean isPalindromeOrganic(String s) {
		
		 boolean flag=false;
		 int n=s.length(),k=0,j=n-1;
		 if(n==1)
			 return true;
		 
		 int mid=n/2;
		 if(n%2==0) {
			 
		 }else {
			 
		 }
		 
//		 for(int i=0;i<mid;i++) {
//			 if(s.charAt())
//		 }
//		while(i<=j) {  
//	         if(s.charAt(i)==s.charAt(j))
//	        	 flag=true;
//	         else {
//	        	 flag=false;
//	        	 break;
//	         }
//	         i++;
//	         j--;
//		}
	     return flag;
	}
	
	
	//gives TLE
	private static boolean isPalindrome(String s) {
		
		 if(s.length()==1)
			 return true;
		 StringBuilder sb=new StringBuilder(s);
		
	    return  sb.reverse().toString().equals(s);
	}
}