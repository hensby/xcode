package antra.example;

public class DeadLockEx {
    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        DeadLockThread1 dt1 = new DeadLockThread1(a,b);
        DeadLockThread2 dt2  = new DeadLockThread2(a,b);

        dt1.start();
        dt2.start();
    }
}
