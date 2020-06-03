import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prakhar_SplashArrays {

    /**
     * Instead of iterating, This approach creates a map of strings to occurence.
     * The map approach can be implemented from scratch by iterating and iterating the count, or leverage the existing groupBy provided by java8. I chose to do the later.
     * Once map is created, Its easy to look up.
     *
     * Complexity : O(n)
     */
    static int[] matchingStrings(final String[] strings, final String[] queries) {

        // Create a Map of each string to its occurence
        final Map<String, Long> stringToCountMap =
                Stream.of(strings).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Get the result off the map
        return Arrays.stream(queries)
                .map(query -> stringToCountMap.getOrDefault(query, 0L))
                .mapToInt(Math::toIntExact).toArray();
    }

    public static void main(String[] args) {

        final String[] strings = {"aba", "baba", "aba", "xzxb"};
        final String[] queries = {"aba", "xzxb", "ab"};

        final int[] output = matchingStrings(strings, queries);

        Arrays.stream(output).forEach(System.out::println);
    }
}
