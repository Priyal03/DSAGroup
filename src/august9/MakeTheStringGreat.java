package leetcode.contest.august9;

public class MakeTheStringGreat {

	public static void main(String[] args) {
		
		String in = "abBAcC";
		MakeTheStringGreat obj = new MakeTheStringGreat();
		
		in = obj.makeGood(in);
		System.out.println(in);
	}
	
	public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
		boolean first=false, second=false; //false means small.
		
		for(int i=0;i<sb.length();i++) {
			
			if((sb.length()-1)==i) {
				break;
			}
			
			first=false; second=false;
			
			if(sb.charAt(i)>64 && sb.charAt(i)<91) {
				first = true;
			}
			
			if (sb.charAt(i+1)>64 && sb.charAt(i+1)<91) {
				second = true;
			}
			
			if(sb.charAt(i)+32 == sb.charAt(i+1) || sb.charAt(i)-32==sb.charAt(i+1)) {
				
				System.out.println("came here!!");
				if(first!=second) {
					sb.delete(i, i+2);
					i=-1;
				}
			}
		}
        return sb.toString();
    }
}
