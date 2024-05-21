package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CollectorsDemo {
    private static final Logger LOG = LoggerFactory.getLogger(CollectorsDemo.class);
    public static void runExample() {
        // joining method
        joinning();
        // counting method
        LOG.info("Counting: {}",StudentDataBase.getAllStudents().stream().filter((s)->s.getGpa()>3.9).collect(counting()));
        //mappping
        LOG.info("Mapping: {}",StudentDataBase.getAllStudents().stream().collect(mapping(Student::getActivities,toList())));
        //Min-Max Average, Sum
        acumulation();
        groupByCollector();

    }

    private static void groupByCollector() {
        LOG.info("group by Overloaded-1: {}",StudentDataBase.getAllStudents().stream().collect(groupingBy(Student::getGender)));
        LOG.info("group by Overloaded-1 with custom key: {}",StudentDataBase.getAllStudents().stream().collect(groupingBy((s)->s.getGpa()>3.9?"GOOD":"AVERAGE")));

        LOG.info("group by Overloaded-2 (Two Layer Grouping)-1: {}",StudentDataBase.getAllStudents().stream().collect(groupingBy(Student::getGender,groupingBy((s)->s.getGpa()>3.9?"GOOD":"AVERAGE"))));
        LOG.info("group by Overloaded-2 (Two Layer Grouping)-2: {}",StudentDataBase.getAllStudents().stream().collect(groupingBy(Student::getGender,summingInt(Student::getNoteBooks))));
        LinkedHashMap<String, Integer> map = StudentDataBase.getAllStudents().stream().collect(groupingBy(Student::getGender,LinkedHashMap::new,summingInt(Student::getNoteBooks)));
        LOG.info("group by Overloaded-3 (With Supplier and Two Layer) {}",map);
        // CollectingAndThen (Used to remove Optional)
        LOG.info("Collecting And Then: {} ",StudentDataBase.getAllStudents().stream().collect(groupingBy(Student::getGradeLevel,collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),Optional::get))));
        //Partion-By
        LOG.info("Partition By Overload-1: {} ",StudentDataBase.getAllStudents().stream().collect(partitioningBy(s->s.getGpa()>3.9)));
        LOG.info("Partition By Overload-2: {} ",StudentDataBase.getAllStudents().stream().collect(partitioningBy(s->s.getGpa()>3.9,toSet())));
    }

    private static void acumulation() {
        LOG.info("MinBy: {}",StudentDataBase.getAllStudents().stream().collect(minBy(Comparator.comparing(Student::getGpa))));
        LOG.info("MaxBy: {}",StudentDataBase.getAllStudents().stream().collect(maxBy(Comparator.comparing(Student::getGpa))));
        LOG.info("Sum: {}",StudentDataBase.getAllStudents().stream().collect(summingInt(Student::getNoteBooks)));
        LOG.info("Average: {}",StudentDataBase.getAllStudents().stream().collect(averagingInt(Student::getNoteBooks)));
    }

    private static void joinning() {
        LOG.info("Join-Overloaded method - 1: {}",StudentDataBase.getAllStudents().stream().map(Student::getName).collect(joining()));
        LOG.info("Join-Overloaded method - 2: {}",StudentDataBase.getAllStudents().stream().map(Student::getName).collect(joining("-")));
        LOG.info("Join-Overloaded method - 3: {}",StudentDataBase.getAllStudents().stream().map(Student::getName).collect(joining("-","(",")")));
    }
}
