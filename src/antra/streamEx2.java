package antra;

import antra.example.Person;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class streamEx2 {

        public static void main(String[] args) {
            List<Person> data = getData();
//       List<Person> data = null;
//       将名字变大写
            data.stream().map(person -> person.getName().toUpperCase()).forEach(i -> System.out.print(i + " "));
//       过滤掉分数不足80的
            data.stream().filter(person -> person.getScore() > 80).forEach(System.out::println);
//       基于分数排序(默认从小到大）   reversed()逆序
            data.stream().sorted(Comparator.comparing(Person::getScore)).forEach(System.out::println);
            data.stream().sorted((i1, i2) -> i1.getScore() - i2.getScore()).forEach(System.out::println);
//       基于分数分组 Map<String, List < Person >>
            data.stream().collect(Collectors.groupingBy(Person::getScore)).forEach((k, v) -> System.out.println(k + " -------- " + v));

//       某个属性是否匹配
            System.out.println(data.stream().anyMatch(Predicate.isEqual(new Person("tom","M", 21, 80))));
            System.out.println(data.stream().anyMatch(i -> i.equals(new Person("tom","M", 21, 80))));
//       某个属性是否匹配
            System.out.println(data.stream().allMatch(Predicate.isEqual(new Person("tom","M", 21, 80))));
//       某个属性是否匹配
            System.out.println(data.stream().map(Person::getName).anyMatch(Predicate.isEqual("whc")));
            System.out.println(data.stream().map(p -> p.getName()).anyMatch(p -> p.equals("whc")));
//       根据某个属性去重
            data.stream().map(Person::getScore).distinct().forEach(System.out::println);
            data.stream().map(p -> p.getScore()).distinct().forEach(System.out::println);
//       求和 平均数 最大数 最小数
            System.out.println(data.stream().mapToInt(Person::getScore).sum());
            System.out.println(data.stream().mapToInt(Person::getScore).average().getAsDouble());
            System.out.println(data.stream().mapToInt(Person::getScore).max().getAsInt());
            System.out.println(data.stream().mapToInt(Person::getScore).min().getAsInt());

//       先分组在分组求和
            data.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.summingInt(Person::getScore))).forEach(((k, v) -> {
                System.out.println(k + " -----------  " + v);
            }));
            data.stream().forEach(p -> {
                System.out.println(p.getAge() + 10);//可能会出现空指针
            });
//       空判断
            Optional.ofNullable(data).ifPresent(source -> {
                source.stream().forEach(p -> {
                    System.out.println(p.getAge() + 10);//不会出现空指针
                });
            });
        }
        public static List<Person> getData() {
            List<Person> data = Arrays.asList(
            new Person("whc", "M", 22, 90),
                    new Person("tom","M", 21, 80),
                    new Person("jerry","F", 40,90),
                    new Person("will","M", 23,80),
                    new Person("rick","F", 10,55),
                    new Person("derrick","M", 30,70));
            return data;
        }


}
