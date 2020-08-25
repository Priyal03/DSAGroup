package leetcode.strings;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		Solution obj=new Solution();
		
		String x = obj.longestPalindrome("cccccdcccccc");
		
		System.out.println(x);
	}
   public String longestPalindrome(String s) {
       HashMap<Integer,String> hmap = new HashMap<>();
       int subStringLen = Integer.MIN_VALUE , n= s.length();
       if(n <2){
           return s;
       }
       
       if(n == 2){
           if(s.charAt(0) == s.charAt(1)){
               return s;
           }else{
               return s.substring(0,1);                
           }
       }
       
       for(int i =0 ; i< n ; i++){
           for(int j=i+1; j<= n ; j++ ){
               if(!hmap.containsKey(s.substring(i,j).length())){
                   int lenA= isPalindrome(s.substring(i,j), hmap);
                   if(lenA > subStringLen){
                     subStringLen = lenA;
                   }
               }
           }
       }
       
       return hmap.get(subStringLen) != null ? hmap.get(subStringLen) : s.substring(0,1);
   }
   
   public static int isPalindrome(String s, HashMap<Integer,String> hm) {
       int i =0, j=s.length()-1;
       boolean flag = false;
       int max = Integer.MIN_VALUE;

       while(i<j){
           if(s.charAt(i) == s.charAt(j)){
               i++;
               j--;
               flag= true;
           }else{
               flag = false;
               break;
           }
       }
       if(flag){
           if(s.length() > max){
               max = s.length();
           }
           hm.put(s.length() , s);
       }
       return max;
   }
}