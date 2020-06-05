import java.util.Arrays;
import java.lang.Math;

public class Prakhar_Mark_Cakewalk {

    /**
     * Idea is sort the calorie array in either descending order or use the array sorted in ascending order.
     * Then Loop the array and apply the formula defined in problem
     *
     * I have used custom Quicksort and Math.pow implemented as part of java SDK
     * however, below are functions implemented in java as well.
     */
    static long marcsCakewalk(int[] calorie) {

        // Arrays.sort internally applies quicksort algorithm, Collectons.sort implements merge sort algorithm
        Arrays.sort(calorie);


        long milesToWalk = 0;
        int i = calorie.length - 1;
        while (i >= 0) {
            milesToWalk += (long) Math.pow(2, calorie.length - (i + 1)) * calorie[i];
            i--;
        }
        return milesToWalk;
    }

    public static void main(String[] args) {

        int[] calorie = {9, 7, 6 ,4};
        long output = marcsCakewalk(calorie);
        System.out.println(output);

        // quickSort(calorie, 0, calorie.length-1);
        // Arrays.stream(calorie).forEach(elem -> System.out.print(elem + " "));
    }

    // Optional Implementations
    static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    // TODO : Research a little about "Power of a variable" algorithms.
}
