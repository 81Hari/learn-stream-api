import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

/**
 * Note:
 * <ul>
 *     <li>Cannot redeclare local variable inside lambda</li>
 *     <li>Cannot modify local variable inside lambda but local varaibles can be read!</li>
 * </ul>
 *
 */
public class LambdaExample
{
    private static final Logger LOGGER = LoggerFactory.getLogger(LambdaExample.class);
    public static void main( String[] args ) throws InterruptedException {
        Runnable legacyRunnable = new Runnable() {
            @Override
            public void run() {
                LOGGER.info("Legacy Runnable");
            }
        };

        Runnable lambdaRunnable = ()->LOGGER.info("Lambda Runnable");
        Thread thread1, thread2;
        thread1 = new Thread(legacyRunnable);
        thread2 = new Thread(lambdaRunnable);
        thread1.start();
        thread2.start();

        Comparator<Integer> legacyComparator = new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1.compareTo(o2);
                    }
                };
        LOGGER.info("Legacy Comparator: {}" , legacyComparator.compare(2,3));

        Comparator<Integer> lambdaComparator = (o1,o2)->o1.compareTo(o2);
        LOGGER.info("Lambda Comparator: {}" , lambdaComparator.compare(3,2));

    }
}
