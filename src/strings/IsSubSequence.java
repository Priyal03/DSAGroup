package leetcode.strings;

public class IsSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = isSubsequence("abc", "ahbgdc");
		
		System.out.println(res);
	}

    public static boolean isSubsequence(String s, String t) {
       
        int j=0, n=s.length();
         char x;
        for(int i=0;i<t.length();i++){
            
            if(j==n)
                return true;
            else{
           
                x=s.charAt(j);
            
                if(t.charAt(i)==x){
                    j++;
                }
            }
        }
        if(j==n)
            return true;
        
        return false;
    }
}