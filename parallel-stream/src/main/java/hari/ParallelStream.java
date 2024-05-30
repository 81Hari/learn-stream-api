package hari;
import hari.employee_test.dao.EmployeeDAO;
import hari.employee_test.dao.EmployeeDAOImple;
import hari.employee_test.helper.EmployeeBuilder;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ParallelStream
{
    private static final Logger LOG = LoggerFactory.getLogger(ParallelStream.class);
    private static final StopWatch stopWatch = new StopWatch();
    private static final EmployeeDAO e = EmployeeDAOImple.getInstance();
    public static void main( String[] args ) {

        for (int i = 0; i < 5; i++) {
            parallelStreamPoorPerformance();
        }

    }

    private static void parallelStreamPoorPerformance() {
        int n = 10_000_000;
        stopWatch.reset();
        stopWatch.start();
        LOG.info("{}",ParallelStreamPoorPerformance.sum_using_intstream(n,false));
        LOG.info("IntStream Sequential Time-Taken: {}",stopWatch.getTime());
        stopWatch.stop();

        stopWatch.reset();
        stopWatch.start();
        LOG.info("{}",ParallelStreamPoorPerformance.sum_using_intstream(n,true));
        LOG.info("IntStream Parallel Time-Taken: {}",stopWatch.getTime());
        stopWatch.stop();

        stopWatch.reset();
        stopWatch.start();
        LOG.info("{}",ParallelStreamPoorPerformance.sum_using_iterate(n,false));
        LOG.info("Iterate Sequential Time-Taken: {}",stopWatch.getTime());
        stopWatch.stop();

        stopWatch.reset();
        stopWatch.start();
        LOG.info("{}",ParallelStreamPoorPerformance.sum_using_iterate(n,true));
        LOG.info("Iterate Parallel Time-Taken: {}",stopWatch.getTime());
        stopWatch.stop();

        stopWatch.reset();
        stopWatch.start();
        LOG.info("{}",ParallelStreamPoorPerformance.sum_using_list(IntStream.rangeClosed(0,n).boxed().collect(Collectors.toList()), false));
        LOG.info("List Sequential Time-Taken: {}",stopWatch.getTime());
        stopWatch.stop();

        stopWatch.reset();
        stopWatch.start();
        LOG.info("{}",ParallelStreamPoorPerformance.sum_using_list(IntStream.rangeClosed(0,n).boxed().collect(Collectors.toList()), true));
        LOG.info("List Parallel Time-Taken: {}",stopWatch.getTime());
        stopWatch.stop();
    }

    private static void linkedListVsArrayList() {
        int n = 10_000_000;
        ArrayList<Integer> aList;
        // Array-List Normal
        stopWatch.reset();
        aList = ParallelStreamExamples.getArrayList(n);
        stopWatch.start();
        LOG.info("{}",ParallelStreamExamples.arrayListPerformanceTest(false,aList));
        stopWatch.stop();
        LOG.info("ArrayList Sequential Time-Taken: {}",stopWatch.getTime());

        // Array-List Parallel
        stopWatch.reset();
        aList = ParallelStreamExamples.getArrayList(n);
        stopWatch.start();
        LOG.info("{}",ParallelStreamExamples.arrayListPerformanceTest(true,aList));
        stopWatch.stop();
        LOG.info("ArrayList Parallel Time-Taken: {}",stopWatch.getTime());

        LinkedList<Integer> lList;
        // Linked-List Normal
        stopWatch.reset();
        lList = ParallelStreamExamples.getLinkedList(n);
        stopWatch.start();
        LOG.info("{}",ParallelStreamExamples.linkedListPerformanceTest(false,lList));
        stopWatch.stop();
        LOG.info("Linked List Sequential Time-Taken: {}",stopWatch.getTime());

        // Linked-List Parallel
        stopWatch.reset();
        lList = ParallelStreamExamples.getLinkedList(n);
        stopWatch.start();
        LOG.info("{}",ParallelStreamExamples.linkedListPerformanceTest(true,lList));
        stopWatch.stop();
        LOG.info("Linked List Parallel Time-Taken: {}",stopWatch.getTime());

    }


}
