package edu.itstep.streamapi;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HowWorksStream {
    public static void main(String[] args) {
        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300)                   // 120 result = true
                .map(x -> x + 11)                       // 120 -> 131
                .limit(3)                       // 120   count = 3
                .forEach(System.out::println);          // print
//
//        System.out.println("================");
//        int[] arr = {120, 410, 85, 32, 314, 12};
//        int count = 0;
//        for (int x : arr) {
//            if (x >= 300) continue;
//
//            x += 11;
//            count++;
//            if (count > 3) break;
//            System.out.println(x);
//        }
//
//        Stream.of(1, 23, 3, 4)
//                .filter(x -> x > 10);
//
        List<String> list = List.of("one", "two", "three", "four", "five", "six");

        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        stream.filter(s -> s.contains("e"));
        stream.forEach(System.out::println);
        // pull iteration
    }
}
