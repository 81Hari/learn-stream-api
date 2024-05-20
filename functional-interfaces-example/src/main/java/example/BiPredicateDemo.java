package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiPredicateDemo.class);
    private static final int N1 = 30;
    private static final BiPredicate<Integer,Integer> IS_DIVISBLE_BY_N = (i,n)->i%n==0;
    public static void runExample(){
        LOGGER.info("Is divisble by both 5 and 6 ({}): {}",N1,(IS_DIVISBLE_BY_N.test(N1,5)&&IS_DIVISBLE_BY_N.test(N1,6)));

    }
}
