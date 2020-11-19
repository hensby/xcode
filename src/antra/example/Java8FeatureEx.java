package antra.example;

public class Java8FeatureEx {
    public static void main(String[] args) {
        I3 i3 = (i, j) -> {   // functional interface impl // lambda
            System.out.println("m1 in main method " + (i + j));
            return i + j;
        };
        System.out.println(i3.m1(1, 3));

    }
}
