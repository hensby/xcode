package antra.example;

public class Task2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("task2222 +  " + i);
        }
    }
}
