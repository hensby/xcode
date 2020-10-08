package antra.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationEX {
    public static void main(String[] args) {
//        String s = new String("wwww");
//        Person p = new Person("whc", 1, "male", "ss");
//        Person q = new Person("whc", 1, "male", "ss");
//
//        System.out.println(p.equals(q));
//        System.out.println(p); //override toString();
//
//        System.out.println(p.hashCode()); // override hashCode();
//
//        String str = new String("old");
//        str.concat("new");
//        String newStr = str.concat("new");
//        System.out.println(str);
//        System.out.println(newStr);
//
//        StringBuffer sb1 = new StringBuffer("old");
//        StringBuffer sb2 = new StringBuffer("old");
//        System.out.println(sb1.equals(sb2));
//        String s1 = sb1.toString();
//        String s2 = sb2.toString();
//        System.out.println(s1.equals(s2));
//        try {
////            FileOutputStream fs1 = new FileOutputStream("person.txt");
////            ObjectOutputStream o = new ObjectOutputStream(fs1);
////            o.writeObject(p);
//
//            FileInputStream fs = new FileInputStream("person.txt");
//            ObjectInputStream o = new ObjectInputStream(fs);
//            Person newP =(Person) o.readObject();
//            System.out.println(newP.name);
//        } catch (Exception e) {
//
//        }


//        String str1 = new String("Manas");
//        String str2 = new String("Str");
//        System.out.println(str1.equals(str2));
//        String str3 = new String("Manas");
//        System.out.println(str1.equals(str3));


        String str4 = new String("ssss");
        String str5 = new String("ssss");
        String str6 = "ssss";
        String str7 = "ssss";
        System.out.println(str4.equals(str6));
        System.out.println(str4 == str6);
        System.out.println(str6 == str7);


    }
}
