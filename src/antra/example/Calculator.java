package antra.example;

public class Calculator {

    public synchronized void printRes(int j) throws InterruptedException { // one thread invoke other wait
        for(int i = 1; i < 6; i++) {
            Thread.sleep(1000);
            System.out.println( j + " * " + i + " = " + i * j );
        }
    }
}
