package leetcode.strings;

import java.util.HashMap;


public class LongestCommonSubSequence {

	private static int count=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = getSubsequence("psnw", "vozsh");

		System.out.println(res+" "+count);
	}

	private static int getSubsequence(String s, String t) {
		// TODO Auto-generated method stub

		//return findlcsRecursive(s,t,s.length(),t.length());
		
		HashMap<String, Integer> map = new HashMap<>();
		
		return findlcsMemo(s,t,s.length(),t.length(),map);
		
	}
//
	private static int findlcsMemo(String s, String t, int sl, int tl, HashMap<String, Integer> map) {
		// TODO Auto-generated method stub
		count++;
		
		if(sl==0 || tl==0) {
			return 0;
		}
		
		String key=sl+","+tl;
		
		if(!map.containsKey(key)) {
			
			if(s.charAt(sl-1)==t.charAt(tl-1)) {
				
				int a =findlcsMemo(s, t, sl-1, tl-1,map);
				map.put(key,  a+1);
			}else {
				
				int a =findlcsMemo(s, t, sl-1, tl,map);
				int b=findlcsMemo(s, t, sl, tl-1,map);
				map.put(key, Math.max(a, b));
			}
		}
		return map.get(key);
	}

	private static int findlcsRecursive(String s, String t, int sl, int tl) {
		// TODO Auto-generated method stub
		count++;
		if(sl==0 || tl==0) {
			return 0;
		}
		
		if(s.charAt(sl-1)==t.charAt(tl-1)) {
			return findlcsRecursive(s, t, sl-1, tl-1)+1;
		}
		
		int a =findlcsRecursive(s, t, sl-1, tl);
		int b=findlcsRecursive(s, t, sl, tl-1);
		return Math.max(a, b);
	}
}
