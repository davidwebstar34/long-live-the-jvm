import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface Webstar{
    void destroyStuff();
}

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T a, U b, V c);
}

public class Test {

    // The syntax for a generic method includes a list of type parameters, inside angle brackets, which appears before the method's return type. 
    // For static generic methods, the type parameter section must appear before the method's return type.
    //
    public static <T, U, R> Function<U, R> partial(BiFunction<T, U, R> f, T x) {
        return (y) -> f.apply(x, y);
    }

    public static <T, U, V, R> Function<V, R> partial2(TriFunction<T, U, V, R> f, T x, U y) {
        return (z) -> f.apply(x, y, z);
    }

    public static void main(String[] args) throws IOException {

        // List objects
        List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5));

        // Lambda example 
        //
        Webstar web = () -> {
            System.out.println("Boom");
        };
	    web.destroyStuff();

        // Partial Application 1
        //
        BiFunction<Integer, Integer, Integer> add = (x, y) -> x + y;
        Function<Integer, Integer> adder = partial(add, 10);
        System.out.println(adder.apply(10));

        // Partial Application 2 - This uses a function with more than two args which is not natively supported in java
        //
        TriFunction<Integer, Integer, Integer, Integer> add2 = (x, y, z) -> x + y + z;
        Function<Integer, Integer> adder2 = partial2(add2, 10, 20);
        System.out.println(adder2.apply(30));

        // Represents a supplier of results.
        Supplier<List<Integer>> supp = () -> list;
        supp.get();

        // Represents an operation that accepts a single input argument and returns no result. Operates via side effects
        Consumer<List<Integer>> cons = (a) -> System.out.println(a);
        cons.accept(supp.get());

        // Scanner
        Scanner scanner = new Scanner(new File("/Users/webstar/test.txt"));
        while(scanner.hasNextLine()) {
            System.out.println(scanner.next());
        }

        // Function
        Function<Integer, Double> half = a -> a / 2.0;
        half = half.andThen(a -> a * 3);
        half = half.compose(a -> a * 2);

        // Stream 
        List<Integer> list2 = list.stream().map(a -> a * 2).collect(Collectors.toList());

        List<Integer> ints = IntStream.of(1,2,3,4,5)
                .boxed()
                .collect(Collectors.toList());
         
        System.out.println(ints);
        
        // Stream operations directly using Optional
        Optional<Integer> max = IntStream.of(1,2,3,4,5)
                        .boxed()
                        .max(Integer::compareTo);
        
        System.out.println(max.get());

        // Predicate
        Predicate<Integer> greaterThan20 = (a -> a > 20);
        Predicate<Integer> lessThan100 = a -> a < 100;

        System.out.println(greaterThan20.and(lessThan100).test(50));

    }
}