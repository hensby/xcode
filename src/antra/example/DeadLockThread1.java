package antra.example;

public class DeadLockThread1 extends Thread{

    B b;
    A a;
    public DeadLockThread1(A a,B b) {
        this.b = b;
        this.a = a;
    }

    @Override
    public void run() {
        a.foo(b);
//        a.last();
    }
}
