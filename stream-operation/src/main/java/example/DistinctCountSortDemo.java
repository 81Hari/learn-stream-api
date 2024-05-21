package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DistinctCountSortDemo {

    private static final Logger LOG = LoggerFactory.getLogger(DistinctCountSortDemo.class);
    private static final Supplier<List<String>> ACTIVITIES =
            () -> StudentDataBase.getAllStudents().stream()
                    .map(Student::getActivities)
                    .flatMap(List::stream)
                    .distinct()
                    .collect(Collectors.toList());
    private static final Supplier<Long> ACTIVITIES_COUNT = () -> StudentDataBase.getAllStudents().stream()
            .map(Student::getActivities)
            .flatMap(List::stream)
            .distinct()
            .count();
    private static final Supplier<List<String>> ACTIVITIES_SORTED = () -> StudentDataBase.getAllStudents().stream()
            .map(Student::getActivities)
            .flatMap(List::stream)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    private static final Supplier<List<Student>> STUDENTS_SORTED = () -> StudentDataBase.getAllStudents()
            .stream()
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList());
    private static final Supplier<List<Student>> STUDENTS_GPA_GT_3 = () -> StudentDataBase.getAllStudents()
            .stream()
            .filter((s)->s.getGpa()>3)
            .collect(Collectors.toList());



    public static void runExample(){
        LOG.info("Activities: {}",ACTIVITIES.get());
        LOG.info("Activities-SORTED: {}",ACTIVITIES_SORTED.get());
        LOG.info("Activities-Count: {}",ACTIVITIES_COUNT.get());
        LOG.info("SORTED");
        STUDENTS_SORTED.get().forEach((s)->LOG.info(s.toString()));
        LOG.info("FILTERED");
        STUDENTS_GPA_GT_3.get().forEach((s)->LOG.info(s.toString()));

    }
}
