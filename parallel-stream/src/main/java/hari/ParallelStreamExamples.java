package hari;

import hari.employee_test.dao.EmployeeDAO;
import hari.employee_test.dao.EmployeeDAOImple;
import hari.employee_test.model.Employee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamExamples {
    private static final EmployeeDAO e = EmployeeDAOImple.getInstance();


    public static List<String> basicExample (boolean isParallel) {
        Stream<String> stream = IntStream.range(1,100).parallel().mapToObj(e::read).map(emp->emp.get().NAME.get()+"-"+emp.get().SALARY.get());
        if(isParallel){
            stream.parallel();
        }
        return stream.collect(Collectors.toList());
    }

    public static ArrayList<Integer> getArrayList(int n){
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.range(0,n).boxed().forEach(arrayList::add);
        return arrayList;
    }
    public static Integer arrayListPerformanceTest (boolean isParallel,ArrayList<Integer> list) {

        Stream<Integer> stream = list.stream().map(i->i*2);
        if (isParallel){
            stream.parallel();
        }

        return stream.reduce(0,Integer::sum);


    }

    public static LinkedList<Integer> getLinkedList(int n){
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntStream.range(0,n).boxed().forEach(linkedList::add);
        return linkedList;
    }
    public static Integer linkedListPerformanceTest (boolean isParallel,LinkedList<Integer> list) {

        Stream<Integer> stream = list.stream().map(i->i*2);
        if (isParallel){
            stream.parallel();
        }

        return stream.reduce(0,Integer::sum);


    }

    private static Integer delay(Integer aLong) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        return aLong;
    }
}
