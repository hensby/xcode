package antra.example;

import java.util.Scanner;

public class AntraText {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("input a");
        int a = sc.nextInt();
        System.out.println("input b");
        int b = sc.nextInt();

        try {
            int div = a/b;
            System.out.println("div: " + div);
        } catch (Exception e) {}
        int add = a + b;
        System.out.println("add: " + add);
    }
}
