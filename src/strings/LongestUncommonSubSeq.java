package leetcode.strings;
//shortest uncommon subsequence. 

//list of subsequences

//how to remove circular dependency.. 
//restructure
//lazy initialization ;creation is done with proxy object.
//setter or field injection -- inject.
//post contructor annotation. -->only one time happens.
//pre destroy method ??? --> only one time happens.

public class LongestUncommonSubSeq {

	private static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int res = getSubsequence("aefawfawfawfaw", "aefawfeawfwafwaef");

		System.out.println(res + " " + count);
	}

	public static int getSubsequence(String a, String b) {

		if (a.equals(b)) {
			return -1;
		} else if (a.length() == b.length()) {
			return a.length();
		} else {
			
			int x = findLUS(a, b, a.length(), b.length());

			if (x == 0)
				return -1;
			return x;
		}
	}

	private static int findLUS(String a, String b, int l1, int l2) {
		// TODO Auto-generated method stub
		
		count++;
		if (l1 == 0 )
			return l2;
		
		if (l2 == 0 )
			return l1;

		if (a.charAt(l1 - 1) != b.charAt(l2 - 1)) {
			return findLUS(a, b, l1 - 1, l2 - 1) + 1;
		}

		int x = findLUS(a, b, l1, l2 - 1);
		int y = findLUS(a, b, l1 - 1, l2);

		return Math.max(x, y);
	}
}
