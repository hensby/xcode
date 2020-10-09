package antra.example;

public class Task1 implements Runnable {


    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            System.out.println("task1111 +  " + i);
        }
    }
}
