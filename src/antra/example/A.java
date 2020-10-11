package antra.example;

public class A {
    public synchronized void foo(B b) {
        System.out.println("foo");
        b.last();
    }

    public synchronized void last() {
        System.out.println("last in A");
    }
}
