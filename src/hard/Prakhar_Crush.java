
package hackerrank.hard;
public class Prakhar_Crush {

    /**
     * Application of Prefix Sum + Difference Array algorithms.
     *
     * Complexity : O(number of queries) + O(inputLengthForArray)
     */
    static long arrayManipulation(final int inputArrLength, final int[][] queries) {

        final long[] arr = new long[inputArrLength + 1]; // Taken in order to have Difference + prefixSum algorithm working correctly.
        for (int[] query : queries) {

            int rangeStart = query[0] - 1;
            int rangeEnd = query[1] - 1;
            int val = query[2];

            // Applying the difference algorithm

            arr[rangeStart] = arr[rangeStart] + val;
            arr[rangeEnd + 1] = arr[rangeEnd + 1] - val;
        }

        // Apply the Prefix Sum algorithm in order to get the final array we would have received if we have gone through brute force.
        long max = Integer.MIN_VALUE;
        for (int i = 1; i < inputArrLength; i++) {
            arr[i] = arr[i-1] + arr[i];
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        final int inputArrLength = 4;
        final int[][] queries = {
                {2,3,603},
                {1,1,286},
                {4,4,882}
        };

        final long output = arrayManipulation(inputArrLength, queries);

        System.out.println(output);
    }
}
