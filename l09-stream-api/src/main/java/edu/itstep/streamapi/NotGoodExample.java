package edu.itstep.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NotGoodExample {

    public static void main(String[] args) {
        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1_000_000)
                .parallel()
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());
        //IntStream
        //LongStream
        //DoubleStream

    }
}
