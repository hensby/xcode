package antra.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx2 {
    public static void main(String[] args) {
        try {
            System.out.println(1 / 0);
            FileInputStream file = new FileInputStream("abc");
//            System.out.println(1 / 0);

//        } catch (FileNotFoundException fe) {
        } catch (Exception fe) {
            fe.printStackTrace();
        } finally {
            System.out.println(" finally");
        }
        System.out.println("in main");
    }
}
