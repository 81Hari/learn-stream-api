package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class LimitAndSkipDemo {
    private static final Logger LOG = LoggerFactory.getLogger(LimitAndSkipDemo.class);

    public static void runExample(){
        List<Integer> list = Arrays.asList(2,3,4,5,6,7,8,9);
        LOG.info("{}",list.stream().limit(4).reduce(0, Integer::sum));
        LOG.info("{}",list.stream().skip(4).reduce(0, Integer::sum));
    }
}
