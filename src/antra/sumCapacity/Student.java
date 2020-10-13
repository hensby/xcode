package antra.sumCapacity;

import java.util.List;
import java.util.Random;

public class Student {

    String stu_name;
    private int sumCapacity;
    private List<Laptop> laptopList;

    public Student(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setLaptopList(List<Laptop> laptopList) {
        if(laptopList.size() <= 3) {
            this.laptopList = laptopList;
        }else {
            System.out.println("One student can only have 3 laptop " + laptopList.size());
        }
    }

    public List<Laptop> getLaptopList() {
        return laptopList;
    }

    public void setSumCapacity(int sumCapacity) {
        this.sumCapacity = sumCapacity;
    }

    public int getSumCapacity() {
        return sumCapacity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_name='" + stu_name + '\'' +
                ", sumCapacity=" + sumCapacity +
                ", laptopList=" + laptopList +
                "}\n";
    }
}
