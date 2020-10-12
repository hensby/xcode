package antra.example;

public class I1Test {
    public static void main(String[] args) {
        I1Impl in = new I1Impl();
        in.m1(); // subclass method
        in.m2();
        in.m3(); // super class method
        I1.m4(); // static
//        in.m4(); //
    }
}