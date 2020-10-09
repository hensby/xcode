package antra.example;

public class testThread {

    public static void main(String[] args) {
        Task1 t1 = new Task1();  // 2 tasks. main + t1

        Task2 t2 = new Task2();
        Thread th2 = new Thread(t1);
        t2.start();
        th2.start();
    }
}