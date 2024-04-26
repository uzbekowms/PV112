package edu.itstep.streamapi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class TerminalExample {

    public static void main(String[] args) {
        Stream
                .of(120, 410, 64, 13, 46)
                .forEach(System.out::println);

        IntStream.range(0, 1_000_000)
                .parallel()
                .filter(x -> x % 10_000 == 0)
                .map(x -> x / 10_000)
                .forEach(System.out::println);


        IntStream.range(0, 1_000_000)
                .parallel()
                .filter(x -> x % 10_000 == 0)
                .map(x -> x / 10_000)
                .forEachOrdered(System.out::println);
        System.out.println("=======================");
        long count = IntStream.range(0, 10)
                .count();
        System.out.println(count);

        List<Integer> list = Stream.of(1, 2, 3)
                .toList();

        String s = Stream.of(1, 2, 3)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", ">"));
        System.out.println(s);

        List<String> list1 = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        System.out.println(list1);

        String[] elements = Stream.of("a", "b", "c", "d")
                .toArray(String[]::new);

        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);
        System.out.println(sum);
        System.out.println("=================");
        int min = Stream.of(20, 11, 45, 78, 13)
                .min(Integer::compare).get();
        System.out.println(min);


        int max = Stream.of(20, 11, 45, 78, 13)
                .max(Integer::compare).get();
        System.out.println(max);
        // (((0 + 1) + 2) + 3)
        // 10 5 = 5 first arg is greater
        // 5 10 = -5 second arg is greater
        // 5 5 = 0 args is equal

        int anySeq = IntStream.range(4, 10_000)
                .findAny()
                .getAsInt();

        System.out.println(anySeq);

        int anyPar = IntStream.range(4, 10_000)
                .parallel()
                .findAny()
                .getAsInt();

        System.out.println(anyPar);

        int firstSeq = IntStream.range(4, 10_000)
                .findFirst()
                .getAsInt();

        System.out.println(firstSeq);

        int firstPar = IntStream.range(4, 10_000)
                .parallel()
                .findFirst()
                .getAsInt();

        System.out.println(firstPar);

        boolean result = Stream.of(1, 2, 3, 4, 5, 6)
                .anyMatch(x -> x == 3);

        System.out.println(result);

        result = Stream.of(1, 2, 3, 4, 5, 6)
                .anyMatch(x -> x == 8);

        System.out.println(result);

        result = Stream.of(1, 2, 3, 4, 5, 6)
                .peek(System.out::println)
                .noneMatch(x -> x == 3);

        System.out.println(result);

        System.out.println(IntStream.range(2, 16)
                .average()
                .getAsDouble());
        System.out.println(IntStream.range(2, 16)
                .sum());

        System.out.println("===========");
        LongSummaryStatistics longSummaryStatistics = LongStream.range(2, 16)
                .summaryStatistics();

        System.out.println(longSummaryStatistics);

        Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toCollection(ArrayDeque::new));


        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(Function.identity(), Function.identity())));


        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.toMap(
                                Function.identity(),
                                i -> String.format("%d * 2 = %d", i, i * 2)
                        )
                ));

        System.out.println(Stream.of(50, 54, 55)
                .collect(Collectors.toMap(
                                i -> (char) i.intValue(),
                                i -> String.format("<%d>", i)
                        )
                ));

        System.out.println(Stream.of(50, 54, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                                i -> i % 5,
                                i -> String.format("<%d>", i),
                                (a, b) -> String.join(", ", a, b)
                        )
                ));
//        System.out.println(Stream.of(50, 54, 55, 69, 20, 19, 52)
//                .collect(Collectors.toMap(
//                                i -> i % 5,
//                                i -> String.format("<%d>", i)
//                        )
//                ));
        System.out.println(Stream.of(50, 54, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                                i -> i % 5,
                                i -> String.format("<%d>", i),
                                (a, b) -> String.join(", ", a, b),
                                () -> new LinkedHashMap<>()
                        )
                ));

        Stream.of("a", "b", "c", "d")
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(), Function.identity()),
                        map -> map.entrySet().stream()
                ))
                .map(e -> e.toString())
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        DoubleSummaryStatistics collect = Stream.of("1").collect(Collectors.summarizingDouble(Double::parseDouble));
        int startYear = 2004;
        class Device {
            int year;
        }

        Device device = new Device();

        Stream.of(new Device(), new Device())
                .sorted(Comparator.comparingInt(x -> x.year))
                .forEach(System.out::println);
    }
}
