package antra.sumCapacity;

import java.util.*;

public class SumCapacity {
    public static void main(String[] args) {
        Student tom = new Student("Tom");
        Student jerry = new Student("Jerry");
        Student lucy = new Student("Lucy");
        Student henry = new Student("Henry");
        Student rick = new Student("Rick");

        List<Student> studentList = Arrays.asList(
            tom,jerry,lucy,henry,rick
        );

        Laptop lenovo = new Laptop("Lenovo", 22000);
        Laptop hp = new Laptop("HP", 21000);
        Laptop dell = new Laptop("Dell", 20000);
        Laptop msi = new Laptop("MSI", 20000);
        Laptop asus = new Laptop("ASUS", 25000);

        List<Laptop> laptopList = Arrays.asList(
                lenovo,hp,dell,msi,asus
        );

        for(Student student : studentList) {
            Random rand = new Random();
            List<Laptop> tmpLaptopList = new ArrayList<>();
            int size = rand.nextInt(3) + 1;
            Set<Integer> indexSet = new HashSet<>();
            while(indexSet.size() < size) {
                indexSet.add(rand.nextInt(5));
            }
            indexSet.stream().forEach(i -> tmpLaptopList.add(laptopList.get(i))); // stream

            student.setLaptopList(tmpLaptopList);
        }
        studentList.stream().forEach(t -> t.getLaptopList().stream().forEach(i1 -> {      // stream
            t.setSumCapacity(t.getSumCapacity() + i1.chargeCapacity);
        }));
//        for(Student t: studentList) {
//            t.getLaptopList().stream().forEach(i1 -> {      // stream
//                t.setSumCapacity(t.getSumCapacity() + i1.chargeCapacity);
//            });
//        }
        System.out.println(studentList);
    }
}
