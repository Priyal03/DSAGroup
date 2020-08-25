package hackerrank.hard;

public class Sushil {

	public static void main(String[] args) {

		int inputArrLength = 4;
		int[][] queries = { { 2, 3, 603 }, { 1, 1, 286 }, { 4, 4, 882 } };

		long output = arrayManipulation(inputArrLength, queries);

		System.out.println(output);
	}

	static long arrayManipulation(int n, int[][] queries) {
        int[] arr = new int[n];
        int[] diffArr = new int[n+1];

        //int qlen =0;
        long max = Long.MIN_VALUE;
        for(int i=0; i< n ; i++){
            arr[i] =0;
            diffArr[i] =0;
        }
        diffArr[n] =0;

        for(int i=0; i< queries.length; i++){
            diffArr[queries[i][0]-1] = diffArr[queries[i][0]-1] + queries[i][2];
            diffArr[queries[i][1]] = diffArr[queries[i][1]] - queries[i][2];
        }

        arr[0] = diffArr[0];
        max = arr[0];
        for(int i =1 ; i< diffArr.length -1; i++){
            arr[i] =arr[i-1] + diffArr[i];

            if(arr[i] > max){
                max = arr[i];
            }
        }
        
    return max;
    }
}
