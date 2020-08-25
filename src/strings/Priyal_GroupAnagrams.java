package leetcode.strings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Priyal_GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String in[]= {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> res = groupAnagrams(in);
		
		Iterator<List<String>> it = res.iterator();
		
		while(it.hasNext()) {
			
			Iterator<String> innerIt = it.next().iterator();
			
			while(innerIt.hasNext())
				System.out.print(innerIt.next()+" ");
			
			System.out.println();
		}
	}
/**
 * TC:O(n)
 * 
 * SC:O(n)
 * 
 * idea is to sort each string and then make a map of occurances of different anagrams just by compairing.
 */
    public static List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res=new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0;i<strs.length;i++){
            
            String curr=strs[i];
            List<String> list=new ArrayList<String>();
            
            char[] sorted = curr.toCharArray();
            
            Arrays.sort(sorted);
            
            curr=new String(sorted);
        	
            if(map.containsKey(curr)) {
        		
        		list=map.get(curr);
        	}	
        	list.add(strs[i]);
        		
        	map.put(curr, list);
        		
        }
        Set<String> keys = map.keySet();
        
        for(String key:keys) {
        	
        	res.add(map.get(key));
        }
        return res;
    }
    
    public static boolean isAna(String curr, String two){
        
       char[] x=curr.toCharArray(); 
       Arrays.sort(x);
       char[] y= two.toCharArray(); 
       Arrays.sort(y);
     
        if(Arrays.equals(x,y))
           return true;
        else 
            return false;
    }
}