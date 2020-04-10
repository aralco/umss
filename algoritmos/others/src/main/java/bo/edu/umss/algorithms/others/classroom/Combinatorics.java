package bo.edu.umss.algorithms.others.classroom;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author ariel.alcocer
 */
public class Combinatorics {
    public static int factorial(int n) {
        if(n==0)
            return 1;
        return n*factorial(n-1);
    }


    public static <T> List<T> permutation(int no, List<T> items) {
        return permutationHelper(no,
                new LinkedList<>(Objects.requireNonNull(items)),
                new ArrayList<>());
    }
    private static <T> List<T> permutationHelper(long no, LinkedList<T> in, List<T> out) {
        if (in.isEmpty()) return out;
        long subFactorial = factorial(in.size() - 1);
        out.add(in.remove((int) (no / subFactorial)));
        return permutationHelper((int) (no % subFactorial), in, out);
    }
    @SafeVarargs
    @SuppressWarnings("varargs") // Creating a List from an array is safe
    public static <T> Stream<Stream<T>> of(T... items) {
        List<T> itemList = Arrays.asList(items);
        return IntStream.range(0, factorial(items.length))
                .mapToObj(no -> permutation(no, itemList).stream());
    }

}
