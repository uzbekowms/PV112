package edu.itstep.streamapi;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelSeqExample {

    public static void main(String[] args) {
        List.of(120, 410, 85, 32, 314, 12)
                .parallelStream()
                .filter(x -> x < 300)
                .map(x -> x * 2)
                .forEach(System.out::println);

        IntStream.range(0, 10)
                .parallel()
                .map(x -> x * 10)
                .sum();
    }
}
