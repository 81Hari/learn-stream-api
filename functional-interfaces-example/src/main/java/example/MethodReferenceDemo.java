package example;

import data.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodReferenceDemo.class);
    /**
     * When we are using the method (both Instance and static) which is reside inside the class of the passed parameter,To use that method <i>syntax</i>: <code>ClassName::method-name</code>
     * For below use-case, we are passing a string, and we are using instance-method which is inside String class So syntax : <code>String::toUpperCase</code>.
     */
    private static final Function<String,String> TO_UPPERCASE = String::toUpperCase;
    /**
     * When we are using method which is not reside in class of the passed parameter, To use that method <i>syntax:</i> <ul><li>For Instance Method: <code>InstanceName::method-name</code></li><li>For Static Method: <code>ClassName::method-name</code></li></ul>
     * For below use-case, we are passing a string, and we are using a method which is inside Logger, now we should use <code>LOGGER::info</code>
     */
    private static final Consumer<String> LOG_INFO = LOGGER::info; // Method-Reference for Instance Method
    /**
     * To create Constructor we use <code>Classname::new</code>
     */
    private static final Supplier<Student> CREATE_STUDENT = Student::new;
    /**
     * To Use Parametized Constructor we use <code>Classname::new</code>
     */
    private static final Function<String,Student> CREATE_STUDENT_1 = Student::new;
    public static void runExample(){
        LOG_INFO.accept(TO_UPPERCASE.apply("Hi"));
        Student student1 = CREATE_STUDENT.get();
        Student student2 = CREATE_STUDENT_1.apply("Hari");
        LOG_INFO.accept(student1.toString());
        LOG_INFO.accept(student2.toString());

    }
}
