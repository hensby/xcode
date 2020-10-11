package antra.example;

public class ThreadPriorityEx {

    public static void main(String[] args) {
        Task2 t1 = new Task2();
        t1.setPriority(Thread.MAX_PRIORITY);
        Task2 t2 = new Task2();
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
    }

}
