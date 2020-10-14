package antra.example;

import java.beans.Transient;
import java.io.Serializable;

public class Person implements Serializable {
    String name; //Transient
    int person_id = 2;
    String sex;
    int age;
    transient String pwd;
    private int score;


    public Person(String name, int person_id, String sex, String pwd) {
        this.name = name;
        this.person_id = person_id;
        this.sex = sex;
        this.pwd = pwd;
    }
    public Person(String name, String sex, int age, int score) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
    }

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                score == person.score &&
                name.equals(person.name) &&
                sex.equals(person.sex);
    }

    @Override
    public String toString() {
        return "name: " + name + " Gender: " + sex + " age: " + age + " score: " + score;
    }

    @Override
    public int hashCode() {
        return 1;
    }

}


