package antra.example;

public class Calculator {

    public synchronized static void calculate() {
        for(int i = 0; i < 5; i++) {
            System.out.println( i + " * " + 2 + " = " + i * 2 );
        }
    }
}
