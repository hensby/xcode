package antra.example;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class LambdaEx {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> {return i + j;};
        System.out.println(biFunction.apply(2,3));

        Supplier<Double> sup = () -> {return Math.random();};
        System.out.println(sup.get());
    }
}
