package antra.example;

public class DeadLockThread2 extends Thread{

    A a;
    B b;

    public DeadLockThread2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        b.bar(a);
//        b.last();
    }
}
