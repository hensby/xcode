package antra;

import java.util.Scanner;

public class DoSomething13 {

    public static void doSomething(int x) {
        System.out.println((1 + x) * x / 2);
    }

    public static void doSomethingHelper(String x1) {
        if(x1.equals("q")) {
            System.out.println("quit");
            return;
        }
        int x = Integer.parseInt( x1 );

        if(x > 0) {
            for(int i = 0; i < x; i++) {
                doSomething(x);
            }
            getInput();
        } else {
            System.out.println("error");
            getInput();
        }
    }

    public static void getInput() {
        Scanner s = new Scanner(System.in);
        System.out.println("input x = ");
        String x = s.nextLine();
        doSomethingHelper(x);
    }

    public static void main(String[] args) {
        getInput();
    }

}
