class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> hs = new HashSet<>();
        int len=0, n= s.length();
        int i=0,j=0;
        
        while (i< n && j < n){
            if(!hs.contains(s.charAt(j))){
                hs.add(s.charAt(j));
                j++;
                len = Math.max(len, j-i);
            }else {
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return len;
    }
}