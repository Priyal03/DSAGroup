public class Prakhar_2dArray {

    /**
     * Iterate the 2D array, Keep on calculating Sum and comparing it against the sum which has been observed currently.
     * I have tried to create the same pattern while calculating totalSum below.
     *
     * Complexity : O(n^n)
     */
    static int hourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE; // Maximum sum can be negative as well
        for(int i = 0; i < arr.length - 1; i++)
        {
            for(int j = 0; j < arr[i].length - 1; j++)
            {
                if (i >= 1 && j >= 1) // Makes sure We do not exceed ArrayIndex
                {
                    int totalSum =
                                arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + // Sum at Top
                                                arr[i][j] +                   // Sum at Center
                                arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];  // Sum at Bottom
                    if (totalSum > maxSum) {
                        maxSum = totalSum;
                    }
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[][] testInput = {
                {-9,-9,-9,1,1,1},
                {0,-9,0,4,3,2},
                {-9,-9,-9,1,2,3},
                {0,0,8,6,6,0},
                {0,0,0,-2,0,0},
                {0,0,1,2,4,0}
        };

        int output = hourglassSum(testInput);

        System.out.println(output);
    }
}
