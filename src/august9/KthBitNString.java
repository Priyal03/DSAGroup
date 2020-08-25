package leetcode.contest.august9;

public class KthBitNString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		KthBitNString obj = new KthBitNString();
		System.out.println(obj.findKthBit(4, 11));
	}

	public char findKthBit(int n, int k) {

		String start = "0";

		while (n-- > 1) {
			start = start + "1" + compute(start);

			System.out.println(start + " at " + n);
		}

		if (k-- > start.length())
			return '0';

		return start.charAt(k);
	}

	private String compute(String start) {

		int len = start.length();
		char[] arr = new char[len];
		int j = 0;

		while (len-- > 0) {

			if (start.charAt(len) == '1')
				arr[j++] = '0';
			else
				arr[j++] = '1';
		}

		return new String(arr);
	}

	private String computeEasy(String start) {

		start = start.replaceAll("0", "x").replaceAll("1", "0").replaceAll("x", "1");

		return new StringBuilder(start).reverse().toString();
	}
}
