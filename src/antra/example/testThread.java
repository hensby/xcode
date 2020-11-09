package antra.example;

public class testThread {

    public static void main(String[] args) {
        Task1 t1 = new Task1();  // 2 tasks. main + t1 // implement runnable
        Thread th1 = new Thread(t1);
        th1.start();

        Task2 t2 = new Task2(); // extends thread
        t2.start();
    }
}