package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class NumericStreamDemo {
    private static final Logger LOG = LoggerFactory.getLogger(NumericStreamDemo.class);
    public static void runExample(){
        int sum1 = Stream.of(1,2,3,4,5,6).reduce(0,Integer::sum);
        /*
            - Problem in above code is all the elements will convert from wrapper class to their primitive and operation will be performed.
            - In Summary: Autoboxing is done which increases the performance overhead
         */

        //Solution

        // range-sum
        int sum2 = IntStream.rangeClosed(1,7).sum();
        int sum3 = IntStream.range(1,7).sum();
        LOG.info("Using Sum method: {}, {}",sum1,sum2);

        //count
        long count1 = IntStream.range(2,10).count();
        long count2 = LongStream.range(2,10).count();
        LOG.info("Using Count method: {}, {}",count1,count2);
        //for-each
        LongStream.range(1,3).forEach((l)->LOG.info("For-Each: {}",l));

        //Double Stream doesn't support range or range closed but alternate solution is
        IntStream.rangeClosed(1,50).asDoubleStream().forEach(s->LOG.info("{}",s));

        // max-min and average
        LOG.info("{}",LongStream.rangeClosed(1,90).max().orElse(0));
        LOG.info("{}",LongStream.rangeClosed(1,90).min().orElse(0));
        LOG.info("{}",LongStream.rangeClosed(1,90).average().orElse(0));

        //Boxing and Unboxing
        List<Integer> integerList = IntStream
                                    .range(0,100) // primitive int
                                    .boxed() // Wrapper Class Integer
                                    .collect(Collectors.toList()); //List<Integer>

        int[] integerArray = Stream
                            .of(1,2,4,5,6) // Wrapper Class (Integer)
                            .mapToInt(Integer::intValue) // Primitive (int)
                            .toArray(); // Primitive Array (int Array)

        LOG.info("List-Using Boxing: {}, Array-element Using Unboxing : {}",integerList,integerArray[3]);

        // map To Obj
        List<Integer> objectList = IntStream
                .of(1,2,4) // Integer to
                .mapToObj((x)->new Integer(x)) // Custom Object
                .collect(Collectors.toList());

        LOG.info("{}",objectList);
    }
}
