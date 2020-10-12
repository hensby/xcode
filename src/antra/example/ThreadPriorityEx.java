package antra.example;

public class ThreadPriorityEx {

    public static void main(String[] args) {
        Task4 t1 = new Task4();
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        Task2 t2 = new Task2();
        t2.setPriority(Thread.NORM_PRIORITY); // 5  MIN_PRIORITY == 1


        t1.start();
        t2.start();
    }

}
