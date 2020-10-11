package antra.example;

public class Calculator {

    public synchronized void printRes(int j) { // one thread invoke other wait
        for(int i = 1; i < 6; i++) {
            System.out.println( j + " * " + i + " = " + i * j );
        }
    }
}
