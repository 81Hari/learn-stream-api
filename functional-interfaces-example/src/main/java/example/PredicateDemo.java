package example;


import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(PredicateDemo.class);
    private static final int N1 = 120;
    private static final int N2 = 25;
    private static final Predicate<Integer> IS_EVEN = (i)->i%2==0;
    private static final Predicate<Integer> IS_DIVISIBLE_BY_FIVE = (i)->i%5==0;
    public static void runExample(){

        // Basic
        LOGGER.info("Is Even Number({}): {}",N1,IS_EVEN.test(N1));
        // Channing Using And
        LOGGER.info("Is Number Even And Divisible By Five ({})  :{}",N2,IS_EVEN.and(IS_DIVISIBLE_BY_FIVE).test(N2));
        // Channing Using OR
        LOGGER.info("Is Number Even Or Divisible By Five ({})  :{}",N2,IS_EVEN.or(IS_DIVISIBLE_BY_FIVE).test(N2));
        // negate
        LOGGER.info("Is Number Odd ({})  :{}",N2,IS_EVEN.negate().test(N2));

    }

    private static final Predicate<Student> IS_GRADE_GREATHER_THAN_THREE = (s)->s.getGradeLevel()>=3;
    private static final Predicate<Student> IS_GPA_GREATHER_THAN_THREE = (s)->s.getGradeLevel()>=3.9;
    public static void runHandsOn(){
        logGradeFilteredStudents();
        logGPAFilteredStudents();
    }

    private static void logGradeFilteredStudents() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if(IS_GRADE_GREATHER_THAN_THREE.test(student)){
                LOGGER.info(student.toString());
            }
        });
    }
    private static void logGPAFilteredStudents() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach(student -> {
            if(IS_GPA_GREATHER_THAN_THREE.test(student)){
                LOGGER.info(student.toString());
            }
        });
    }
}
