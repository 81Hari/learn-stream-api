package example;

import data.Student;
import data.StudentDataBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class MatchDemo {
    private static final Logger LOG = LoggerFactory.getLogger(MatchDemo.class);

    public static void runExample(){
        List<Student> studentList = StudentDataBase.getAllStudents();
        LOG.info("{}",studentList.stream().allMatch((s)->s.getGpa()>3.9));
        LOG.info("{}",studentList.stream().anyMatch((s)->s.getGpa()>3.9));
        LOG.info("{}",studentList.stream().noneMatch((s)->s.getGpa()>3.9));
    }
}
