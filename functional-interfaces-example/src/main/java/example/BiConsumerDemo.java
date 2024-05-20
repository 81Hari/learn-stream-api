package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BiConsumerDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(BiConsumerDemo.class);

    /**
     * Basics of BiConsumer
     */
    private static final BiConsumer<String,String> LOG_STRING = (para1,para2)->LOGGER.info("Parameter-1: {}, Parameter-2: {}",para1,para2);
    private static final BiConsumer<Integer,Integer> LOG_INTEGER = (para1,para2)->LOGGER.info("Parameter-1: {}, Parameter-2 {}",para1,para2);
    private static final BiConsumer<Integer,Integer> PRODUCT_OF = (num1,num2)->LOGGER.info("Product-of {} and {} : {}",num1,num2,num1*num2);
    private static final BiConsumer<Integer,Integer> DIVIDE = (num1,num2)->LOGGER.info("Divide-of {} and {} : {}",num1,num2,num1/num2);

    public static void runExample(){
        LOG_STRING.accept("Message-1","Message-2"); // Basic
        LOG_INTEGER.andThen(PRODUCT_OF).andThen(DIVIDE).accept(10,5); // Chaining
    }

    /**
     * Real-World Example
     */
    private static final BiConsumer<String,List<String>> LOG_STUDENT_NAME_AND_ACTIVITY = (name,activities) -> LOGGER.info("Name: {}\tActivities: {}",name,activities);
    public static void runHandsOn(){
        logStudentNameAndActivity();

    }

    private static void logStudentNameAndActivity() {
        List<Student> students = StudentDataBase.getAllStudents();
        students.forEach((student -> LOG_STUDENT_NAME_AND_ACTIVITY.accept(student.getName(),student.getActivities())));
    }
}
