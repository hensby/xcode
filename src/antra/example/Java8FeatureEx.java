package antra.example;

public class Java8FeatureEx {
    public static void main(String[] args) {
        I3 i3 = (i) -> {   // functional interface impl // lambda
            System.out.println("m1 in main method " + i);
        };
        i3.m1(1);

    }
}
