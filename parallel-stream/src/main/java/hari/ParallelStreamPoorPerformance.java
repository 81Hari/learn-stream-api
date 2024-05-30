package hari;



import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;



public class ParallelStreamPoorPerformance {


    public static int sum_using_intstream(int count, boolean isParallel) {
        IntStream intStream = IntStream.rangeClosed(0, count);

        if (isParallel)
            intStream.parallel();

        int sum = intStream
                .sum();

        return sum;
    }


    public static int sum_using_list(List<Integer> inputList, boolean isParallel) {

        Stream<Integer> inputStream = inputList.stream();

        if (isParallel)
            inputStream.parallel();

        int sum = inputStream
                .mapToInt(Integer::intValue) // unboxing
                .sum();

        return sum;
    }

    public static int sum_using_iterate(int n, boolean isParallel) {

        Stream<Integer> integerStream = Stream.
                iterate(0, i -> i + 1);


        if (isParallel)
            integerStream.parallel();

        int sum = integerStream
                .limit(n + 1) // includes the end value too
                .reduce(0, Integer::sum);


        return sum;
    }
}

