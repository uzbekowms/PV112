package edu.itstep.streamapi;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<String> list = List.of("one", "two", "three", "four", "five", "six");
        list.forEach(System.out::println);

        Predicate<String> lowerOrEqualThanFour = s -> s.length() <= 4;
        Predicate<String> greaterOrEqualThanThree = s -> s.length() >= 4;
        System.out.println("===========================");
        list.stream()
                .filter(lowerOrEqualThanFour.and(greaterOrEqualThanThree))
                .forEach(System.out::println);

        System.out.println("===========================");
        list.stream()
                .filter(greaterOrEqualThanThree)
                .forEach(System.out::println);

    }
}
