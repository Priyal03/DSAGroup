import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prakhar_BoardCutting {
    public static long MODULO = 1000000007;

    private static BufferedReader getStdinReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Need to input as long instead of integer.
     */
    private static long[] parseLongs(String text) {
        String[] numberTexts = text.split(" ");
        long[] values = new long[numberTexts.length];
        for(int i = 0; i < numberTexts.length; i++) {
            values[i] = Long.parseLong(numberTexts[i]);
        }
        return values;
    }

    /**
     * Reverse function since java8 does not support reverse sorting on primitive data types.
     * @param array
     */
    private static void reverse(long [] array) {
        long tmp;
        for(int i = 0; i < array.length / 2; i++) {
            tmp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader in = getStdinReader()) {
            int maxInputs = Integer.parseInt(in.readLine());

            for(int inputIndex = 0; inputIndex < maxInputs; inputIndex++) {
                long[] horizontalCutCosts = parseLongs(in.readLine());
                long[] verticalCutCosts = parseLongs(in.readLine());

                // Sort
                Arrays.sort(horizontalCutCosts);
                Arrays.sort(verticalCutCosts);

                // Descending Order sort
                reverse(horizontalCutCosts);
                reverse(verticalCutCosts);

                int i=0;
                int j=0;
                long y_cuts_required = 1;
                long x_cuts_required = 1;

                long cost = 0;

                while (i<horizontalCutCosts.length && j <verticalCutCosts.length)
                {
                    if (horizontalCutCosts[i] > verticalCutCosts[j]) {
                        cost += (horizontalCutCosts[i] * x_cuts_required) % MODULO;
                        y_cuts_required += 1;
                        i++;
                    }
                    else {
                        cost += (verticalCutCosts[j] * y_cuts_required) %  MODULO;
                        x_cuts_required += 1;
                        j++;
                    }
                }

                while (i < horizontalCutCosts.length) {
                    cost += (horizontalCutCosts[i] * x_cuts_required) % MODULO;
                    i++;
                }

                while (j < verticalCutCosts.length) {
                    cost += (verticalCutCosts[j] * y_cuts_required) % MODULO;
                    j++;
                }

                cost %= MODULO;

                System.out.println(cost);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
