package antra.example;

public class Calculator {

    public synchronized void printRes(int j) {
        for(int i = 0; i < 5; i++) {
            System.out.println( j + " * " + i + " = " + i * j );
        }
    }
}
