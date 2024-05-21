package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FactoryMethodsDemo {
    private static final Logger LOG = LoggerFactory.getLogger(FactoryMethodsDemo.class);
    public static void runExample(){
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        integerStream.forEach((e)->LOG.info("{}",e));

        Stream<Integer> infiniteStream = Stream.iterate(1,x->x+1);
        infiniteStream.skip(10).limit(10).forEach((e)->LOG.info("{}",e));

        Supplier<Integer> supplier = new Random()::nextInt;
        Stream<Integer> infiniteStream1 = Stream.generate(supplier);
        infiniteStream1.limit(10).forEach((e)->LOG.info("{}",e));
    }
}
