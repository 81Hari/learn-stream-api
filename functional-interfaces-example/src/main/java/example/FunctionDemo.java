package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(FunctionDemo.class);

    private static final Function<String,String> TO_UPPERCASE =(s) -> s.toUpperCase();
    private static final Function<String,String> ADD_STRING =(s) -> s + "-World";

    public static void runExample(){

        // Simple
        LOGGER.info(TO_UPPERCASE.apply("Hello"));

        // With And-Then
        LOGGER.info(TO_UPPERCASE.andThen(ADD_STRING).apply("Hello"));

        // With Compose
        LOGGER.info(TO_UPPERCASE.compose(ADD_STRING).apply("Hello"));
    }

    private static final Function<List<Student>, Map<String,Integer>> TO_MAP = (students)->{
        Map<String,Integer>  map = new HashMap<>();
        Consumer<Student> ADD_STUDENT_TO_MAP = student -> map.put(student.getName(),student.getGradeLevel());
        students.forEach(ADD_STUDENT_TO_MAP);
        return map;
    };
    public static void runHandsOn(){
        List<Student> students = StudentDataBase.getAllStudents();
        Map<String,Integer>  map = TO_MAP.apply(students);
        LOGGER.info("{}",map);
    }

}
