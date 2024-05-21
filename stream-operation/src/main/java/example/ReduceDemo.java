package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ReduceDemo {

    private static final Logger LOG = LoggerFactory.getLogger(DistinctCountSortDemo.class);
    private static final Function<List<Integer>, Integer> productOfElements = (list)->list.stream().reduce(1,(product,ele)->product*ele);
    private static final Function<List<Integer>, Optional<Integer>> productOfElementsWithoutAccum = (list)->list.stream().reduce((product, ele)->product*ele);
    private static final Function<List<Student>, Optional<Student>> highestGPAStudent = (list)->list.stream().reduce((highGPAStudent, student)->highGPAStudent.getGpa()>=student.getGpa()?highGPAStudent:student);
    public static void runExample(){
        List<Integer> list = Arrays.asList(2);
        LOG.info("Result: {}",productOfElements.apply(list));
        LOG.info("Result: {}", productOfElementsWithoutAccum.apply(list).orElse(0));
        LOG.info("Result:{}",highestGPAStudent.apply(StudentDataBase.getAllStudents()));
    }
}
