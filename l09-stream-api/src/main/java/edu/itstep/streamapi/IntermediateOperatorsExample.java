package edu.itstep.streamapi;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperatorsExample {

    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .filter(x -> x % 2 == 0)        // фільтрація елементів по Predicate
                .forEach(System.out::println);

        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(System.out::println);

//        Stream.empty()
//                .mapToDouble() // перевести об'єктний стрім в примітивний
//        IntStream.empty()
//                .mapToObj() // перевести примітивний стрім в об'єктний
        System.out.println("===================");
        Stream.of(2, 3, 0, 1, 3)
                .flatMap(x -> {
                            return switch (x % 3) {
                                case 0 -> Stream.of(x, x * x, x * x * x);
                                case 1 -> Stream.of(x);
                                case 2 -> Stream.of(x, x * x);
                                default -> Stream.empty();
                            };
                        }
                )
                .forEach(System.out::println);
        System.out.println("===================");

        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(System.out::println);
        // flatMap - Потрібен для розкладання якогось елементу на стрім Stream.empty(), Stream.of(x), Stream.of(x, x1, ..., xn)
//        Stream.of("Hello", "World")
//                .flatMap(
//                        s -> Arrays.stream(s.toCharArray())
//                ).forEach(System.out::println);
        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    if (x % 2 == 0) {
                        return Stream.of(-x, x);
                    }
                    return Stream.empty();
                })
                .forEach(System.out::println);
        Stream.of(1, 2, 3, 4, 5, 6)
                .mapMulti((x, consumer) -> {
                    if (x % 2 == 0) {
                        consumer.accept(-x);
                        consumer.accept(x);
                    }
                })
                .forEach(System.out::println);

        Stream.of(120, 410, 85, 32, 314, 12)
                .limit(4)
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5, 6)
                .skip(3)
                .forEach(System.out::println);
        System.out.println("===========================");
        IntStream.range(0, 10)
                .skip(5)
                .limit(3)
                .skip(1)
                .forEach(System.out::println);

        IntStream.range(0, 1_000_000)
                .sorted()
                .limit(3)
                .forEach(System.out::println);
        Stream.of(120, 410, 85, 32, 314, 12)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("===========================");

        Stream.of(2, 1, 8, 1, 3, 2)
                .distinct()
                .forEach(System.out::println);

        Stream.of(0, 3, 0, 5)
                .peek(x -> System.out.println("before distinct: " + x))
                .distinct()
                .peek(x -> System.out.println("After distinct: " + x))
                .map(x -> x * x)
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 2, 5)
                .takeWhile(x -> x < 3)
                .forEach(System.out::println);
        System.out.println("=====================");

        Stream.of(1, 2, 3, 4, 2, 5)
                .dropWhile(x -> x >= 3)
                .forEach(System.out::println);

        System.out.println("=====================");
        Stream.of(1, 2, 3, 4, 2, 5)
                .dropWhile(x -> x < 3)
                .forEach(System.out::println);

        DoubleStream
                .of(0.1)
                .boxed()
                .map(Object::getClass)
                .forEach(System.out::println);
    }
}
