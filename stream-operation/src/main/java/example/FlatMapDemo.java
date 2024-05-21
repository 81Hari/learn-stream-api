package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FlatMapDemo {

    private static final Logger LOG = LoggerFactory.getLogger(FlatMapDemo.class);
    private static final Supplier<Set<String>> ACTIVITIES =
            () -> StudentDataBase.getAllStudents().stream()
                    .map(Student::getActivities)
                    .flatMap(List::stream)
                    .collect(Collectors.toSet());

    public static void runExample() {
        LOG.info("{}",ACTIVITIES.get());
    }
}
