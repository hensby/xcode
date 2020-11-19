package antra.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamEx {
    //Stream api
    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> {return i + j;};
        System.out.println(biFunction.apply(1,2));

        Supplier<Double> randomNum = ()->{return Math.random();};
        System.out.println(randomNum.get());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            list.add(i);
        }

        Stream<Integer> stream = list.stream();
        Consumer<Integer> cm = (i) -> {
            System.out.print(i + " ");
        };
        stream.forEach(cm);

        System.out.println();

        list.stream().forEach((i) -> {
            System.out.print(i + " ");
        });

        System.out.println();

        List<Integer> newList = list.stream().filter((i)-> i < 10).collect(Collectors.toList());
        newList.stream().forEach((i)-> {
            System.out.print(i + " ");
        });

        System.out.println();

        newList = list.stream().filter((i)->i > 10).map((i) -> i + 1).collect(Collectors.toList());
        newList.stream().forEach((i)-> System.out.print(i + " "));

        System.out.println();

        List<Person> personList = Arrays.asList(
            new Person("whc", "M", 22),
            new Person("tom","M", 21),
            new Person("jerry","F", 40),
            new Person("will","M", 23),
            new Person("rick","F", 10),
            new Person("derrick","M", 30)
        );

        List<Person> newPersonList = personList.stream().filter( (p) -> p.getSex().equals("M")).collect(Collectors.toList());
        newPersonList.stream().forEach(i -> System.out.print(i.getName() + " "));

        System.out.println();

        newPersonList = personList.stream().filter(p -> p.getSex().equals("M")).map(p -> {
            p.setAge(p.getAge() + 100);
            return p;
        }).collect(Collectors.toList());
        newPersonList.stream().forEach(i -> System.out.print(i + " "));

    }
}
