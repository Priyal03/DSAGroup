class Solution {
    public boolean increasingTriplet(int[] arr) {
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        int n=arr.length;
        if(n < 3){
            return false;
        }
        
       for(int i=0; i<n ; i++){
           if((left < mid)  && (mid < arr[i])){
               return true;
           }else if(arr[i] < left) {
               left = arr[i];
           }
           else if(arr[i] < mid && arr[i] > left){
               mid = arr[i];
           }
       }
        return false;
    }
}