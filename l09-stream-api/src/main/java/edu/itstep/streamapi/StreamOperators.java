package edu.itstep.streamapi;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOperators {
    public static void main(String[] args) {
        Stream.empty()      // порожній стрім
                .forEach(System.out::println);

        Stream.of(1, 2, 3)      //створення стріму з перерахованих елементів
                .forEach(System.out::println);

        String str = Math.random() > 0.5 ? "Hello" : null;

        Stream.ofNullable(str)
                .forEach(System.out::println);

        Stream.generate(Math::random) // повертає стрім з нескінченною послідовністю елементі що генерується функцією
                .limit(6)
                .forEach(System.out::println);

        Stream.iterate(2, x -> x + 6)       //нескінченний стрім з елементами які утворюються в результаті застосування функції f до значення яке ітерується
                .limit(6)
                .forEach(System.out::println);
        // seed -> f(seed) -> f(f(seed))

        Stream.iterate(2, x -> x < 30, x -> x + 6)  //додається перевірка для закінчення генерації
                .forEach(System.out::println);

        Stream.concat(          //об'єднання двух стрімів
                        Stream.of(1, 2, 3),
                        Stream.of(4, 5, 6)
                )
                .forEach(System.out::println);

        Stream.Builder<Integer> streamBuilder = Stream.<Integer>builder()
                .add(0)
                .add(1);

        for (int i = 2; i <= 8; i++) {
            streamBuilder.accept(i);
        }

        streamBuilder
                .add(9)
                .add(10)
                .build()
                .forEach(System.out::println);

        IntStream
                .range(0, 10)
                .forEach(System.out::println);


        IntStream
                .rangeClosed(0, 10)
                .forEach(System.out::println);
    }
}
