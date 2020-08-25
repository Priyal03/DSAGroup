package leetcode.sort.search;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
public class TopKFrequentElements {
	public static void main(String[] args) {
		
		int arr[]=new int[] {0,1,2,2,1,2};
		sortColors(arr,2);
		
	//	onePass(arr);
	}
   
	private static void sortColors(int[] nums, int k) {
        
		Map<Integer,Integer> occur = new HashMap<Integer,Integer>();
		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
		int arr[]=new int[k];
        for(int i=0;i<nums.length;i++){
            
            int key=nums[i];
            
            occur.computeIfPresent(key,(x,v)->v+1);
            
            occur.computeIfAbsent(key,v->1);
        }
        
		occur.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		.forEachOrdered(x->reverseSortedMap.put(x.getKey(), x.getValue()));
		
		Iterator<Integer> keys = reverseSortedMap.keySet().iterator();
		
		while(k-->0) {
			
			if(keys.hasNext()) {
				arr[k]=keys.next();
			 
			}
		}
    }
}