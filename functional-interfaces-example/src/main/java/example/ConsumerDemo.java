package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo{
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);


    private static final Consumer<String> LOG_WITH_PREFIX = (s) -> LOGGER.info("Mr." + s );
    /**
     * How to create Consumer is referred in this method
     */
    public static void runExample(){

        LOG_WITH_PREFIX.accept("Hari");
    }

    private static final Consumer<Student> LOG_STUDENT_NAME = (student -> LOGGER.info(student.getName()));
    private static final Consumer<Student> LOG_STUDENT_ACTIVITY = (student -> LOGGER.info("{}",student.getActivities()));
    private static final Consumer<Student> LOG_STUDENTS = (student)->LOGGER.info("{}",student);
    public static void runHandsOn(){
        logStudents();
        logStudentNameAndActivity();

    }

    /**
     * For Consumer Channing refer this method
     */
    private static void logStudentNameAndActivity() {

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(LOG_STUDENT_NAME.andThen(LOG_STUDENT_ACTIVITY));
    }

    /**
     * How this consumer can be used in realtime is referred here
     */
    private static void logStudents() {

        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(LOG_STUDENTS);
    }
}
