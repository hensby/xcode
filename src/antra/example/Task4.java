package antra.example;

public class Task4 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("task4444 +  " + i);
        }
    }
}
