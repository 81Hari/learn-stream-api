package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class FindDemo {

    private static final Logger LOG = LoggerFactory.getLogger(FindDemo.class);
    public static void runExample(){
        List<Student> students = StudentDataBase.getAllStudents();
        Optional<Student> student1 = students.stream().filter((s)->s.getGpa()>3.9).findAny();
        Optional<Student> student2 = students.stream().filter((s)->s.getGpa()>3.9).findFirst();
        LOG.info("{}",student1.orElse(null));
        LOG.info("{}",student2.orElse(null));
    }
}
