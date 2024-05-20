package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndBinaryOperatorDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnaryAndBinaryOperatorDemo.class);
    private static final UnaryOperator<Integer> MULTIPLY_2 = (i)->i*2;
    private static final UnaryOperator<Integer> MULTIPLY_3 = (i)->i*3;
    private static final BinaryOperator<Integer> MULTIPLY = (i,j)->i*j;

    private static final Comparator<Integer> comparator = (x,y)->x.compareTo(y);
    private static final BinaryOperator<Integer> MAX_BY = BinaryOperator.maxBy(comparator);
    private static final BinaryOperator<Integer> MIN_BY = BinaryOperator.minBy(comparator);
    public static void runExample(){
        LOGGER.info("{}",MULTIPLY_2.apply(2));
        LOGGER.info("{}",MULTIPLY_2.compose(MULTIPLY_3).apply(3));
        LOGGER.info("{}",MULTIPLY.andThen(MULTIPLY_3).apply(3,3));
        LOGGER.info("Max-Value: {}",MAX_BY.apply(3,4));
        LOGGER.info("Max-Value: {}",MIN_BY.apply(3,4));
    }
}
