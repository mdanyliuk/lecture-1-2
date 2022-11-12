import java.util.Comparator;
import java.util.stream.Stream;

public class Task1 {

    /**
     * Returns an array of non-negative numbers from given array of Integer.
     *
     * @param arr given array of Integer, must be not null
     * @return array of non-negative numbers sorted in descending order
     */
    public Integer[] findPositiveNumbers(Integer[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Parameter must be not null");
        }
        return Stream.of(arr)
                .filter(n -> n >= 0)
                .sorted(Comparator.reverseOrder())
                .toArray(Integer[]::new);
    }
}
