import java.util.stream.IntStream;

public class Prakhar_Candies {

    /**
     * Linear Passes, Inline explanation provided
     * TODO : Think of more solutions
     * Time Complexity O(n)
     */
    static long candies(int numberOfStudents, int[] ratings) {

        // Initial Candies assignment to 1
        int[] candies = IntStream.range(0, numberOfStudents).map(i -> 1).toArray();

        // Go forward, extra 1 only when the student sitting after has a rating > than the student sitting before
        IntStream.range(0, (numberOfStudents - 1)).filter(i -> ratings[i] < ratings[i + 1]).forEachOrdered(i -> candies[i + 1] = candies[i] + 1);

        // Come backward
        // When student sitting after has a greater score, this means that the student with greater score should have more candy
        // Hence increase the candy count by 1 and check if student with greater score still has more or equal.
        // This way it will keep track of both sides.
        for(int i=numberOfStudents-1; i>0; i--)
            if (ratings[i] < ratings[i - 1]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }

        long sum = 0;
        for(int i=0;i<numberOfStudents;i++){
            sum +=candies[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] rating = {2,4,2,6,1,7,8,9,2,1};
        long optimalCandies = candies(rating.length, rating);
        System.out.println(optimalCandies);
    }
}
