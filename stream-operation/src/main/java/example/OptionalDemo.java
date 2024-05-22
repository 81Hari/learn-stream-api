package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class OptionalDemo {
    private static final Logger LOG = LoggerFactory.getLogger(OptionalDemo.class);

    public static void runExample() {
        // Without Optional
        String name = getNamewithoutOptional();
        LOG.info("Length of the Name without optional: {}",name!=null?name.length():0);
        Optional<String> optionalName = getNameWithOptional();
        LOG.info("Length of the Name with optional: {}",optionalName.orElse("").length());

        //orElse will return value if value not there it will return the passed the value.
        name = Optional.ofNullable(StudentDataBase.studentSupplier.get()).map(Student::getName).orElse("There is No Student");
        LOG.info("Student Name: {}",name);
        //orElseGet will return value if value not there it will execute the passed supplier and return the value.
        name = Optional.ofNullable(StudentDataBase.studentSupplier.get()).map(Student::getName).orElseThrow(()->new RuntimeException("No Student Data"));

        // Note: In Comparator we can chain the sorting algorithm. and we can handle the null elements in the sorting
    }

    private static Optional<String> getNameWithOptional() {
        Optional<Student> student = Optional.ofNullable(StudentDataBase.studentSupplier.get()); // use OfNullable when you don't know the value is null or not
        return student.map(Student::getName);
    }

    private static String getNamewithoutOptional() {
        Student student = StudentDataBase.studentSupplier.get();
        return student!=null ? student.getName():null;
    }
}
