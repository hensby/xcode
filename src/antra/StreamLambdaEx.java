package antra;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class StreamLambdaEx {
//    1)	Given a list of Objects, write a method that returns a list of all strings that
//    start with the letter 'a' (lower case) and have exactly 3 letters.
//    TIP: Use Java 8 Lambdas and Streams API's.
    public static List<String> search(List<String> list) {
        //write the stream logic hear
        return list.stream().filter(i -> i.charAt(0) == 'a' && i.length() == 3).collect(Collectors.toList());
    }

//    2)	Write a method that returns a comma separated string based on a given list of integers.
//    Each element should be preceded by the letter 'e' if the number is even,
//    preceded by the letter 'o' if the number is odd.
//    For example, if the input list is (3,44), the output should be 'o3,e44'.
    public static String getString(List<Integer> list) {
        //Write the stream logic hear
        return list.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(joining(","));
    }

//    3)	Write a method that returns the average of a list of integers.
    public static Double average(List<Integer> list) {
        //write the stream logic hear
        return list.stream().mapToInt(i -> i).average().getAsDouble();
    }

//    4)	Write a method that converts all strings in a list to their upper case.
    public static List<String> upperCase(List<String> list) {
        //write the stream logic hear
        return list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("String", "string", "str", "Str", "aStr", "AStr", "abc", "abd", "aaa", "ast");
        System.out.println(search(list1));
        List<Integer> list2 = Arrays.asList(3,22,45,33,98,20,5,92);
        System.out.println(getString(list2));
        System.out.println(average(list2));
        System.out.println(upperCase(list1));
    }
}
