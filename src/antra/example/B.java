package antra.example;

public class B {

    public synchronized void bar(A a) {
        System.out.println("bar");
        a.last();
    }

    public synchronized void last() {
        System.out.println("last in B");
    }
}
