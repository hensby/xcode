package antra.example;

public interface I1 extends I2 {
//public interface I1 {
    public void m1();
    public default void m2() {
        System.out.println("in m2");
    }
    public default void m3() {
        System.out.println("in m3");
    }

    public static void m4() {
        System.out.println("in m4");
    }
}
