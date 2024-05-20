package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {
    private static final Logger LOGGER = LoggerFactory.getLogger(SupplierDemo.class);
    private static final Supplier<List<Student>> STUDENTS_SUPPLIER = ()-> StudentDataBase.getAllStudents();
    public static void runExample(){
        LOGGER.info("{}",STUDENTS_SUPPLIER.get());
    }
}
