public class LongCommonSubString {
    public static int lcs(String x , String y){
        int m = x.length();
        int n = y.length();
        int[][] lcsMat = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    lcsMat[i][j] =0;
                }else if(x.charAt(i-1) == y.charAt(j-1)){
                    lcsMat[i][j] = lcsMat[i-1][j-1] +1;
                }else{
                    lcsMat[i][j] = Math.max(lcsMat[i-1][j], lcsMat[i][j-1]);
                }
            }
        }
        
        return lcsMat[m][n];
    }
    public static void main (String[] args)
    {
        String X = "stone";
        String Y = "longest";

        System.out.println(lcs(X, Y));
    }
}
