package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MapDemo {

    private static final Logger LOG = LoggerFactory.getLogger(MapDemo.class);
    private static final Supplier<List<String>> STUDENT_NAMES =
            () -> StudentDataBase.getAllStudents().stream()
                    .map(Student::getName)
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

    public static void runExample() {
        LOG.info("{}",STUDENT_NAMES.get());

    }


}
