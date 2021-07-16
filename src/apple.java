import antra.sumCapacity.Student;

import java.util.*;

public class apple {

    public static Map<String, Integer> demo (List<Student> list) {
        Map<String, Integer> res = new HashMap<>();
        list.stream().forEach(s -> {
            res.put(s.getStu_name(), res.getOrDefault(s.getStu_name(), 0) + 1);
        });
        return res;
    }

    public static void main(String[] args) {
        Student tom = new Student("Tom");
        Student jerry = new Student("Jerry");
        Student lucy = new Student("Lucy");
        Student henry = new Student("Henry");
        Student rick = new Student("Rick");
        Student rick1 = new Student("Rick");

        List<Student> studentList = Arrays.asList(
                tom,jerry,lucy,henry,rick, rick1
        );
        System.out.println(demo(studentList));
    }
}
