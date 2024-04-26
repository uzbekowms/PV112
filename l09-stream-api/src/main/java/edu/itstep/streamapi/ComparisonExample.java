package edu.itstep.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ComparisonExample {
    public static void main(String[] args) {

    }

    public static List<String> filter(List<String> elements, Predicate<String> predicate) {
        List<String> filteredElements = new ArrayList<>();
        for (String element : elements) {
            if (predicate.test(element)) {
                filteredElements.add(element);
            }
        }
        return filteredElements;
    }

    public static List<String> filterLikeStream(List<String> elements, Predicate<String> predicate) {
        return elements.stream()
                .filter(predicate)
                .toList();
    }
}
