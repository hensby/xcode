package antra.example;

import java.beans.Transient;
import java.io.Serializable;

public class Person implements Serializable {
    String name; //Transient
    int person_id = 2;
    String sex;
    transient String pwd;

    public Person(String name, int person_id, String sex,String pwd) {
        this.name = name;
        this.person_id = person_id;
        this.sex = sex;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "toString";
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
