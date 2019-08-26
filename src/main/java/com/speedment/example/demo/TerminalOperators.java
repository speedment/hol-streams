package com.speedment.example.demo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class TerminalOperators {

    public static void main(String[] args) {

        Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .forEachOrdered(System.out::print);

        System.out.println();

        Set<String> collectToSet = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(Collectors.toSet());

        print("toSet", collectToSet);


        List<String> collectToList = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(Collectors.toList());

        print("collectToList", collectToList);

        LinkedList<String> collectToCollection = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(Collectors.toCollection(LinkedList::new));

        print("collectToCollection", collectToCollection);

        String collectJoining = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(Collectors.joining("+", "<", ">"));

        print("collectJoining", collectJoining);


        StringBuilder collectCustom = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(
                StringBuilder::new,    // Supplier
                StringBuilder::append, // Accumulator
                StringBuilder::append  // Combiner
            );

        print("collectCustom", collectCustom);


        String[] toArray = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .toArray(String[]::new);

        print("toArray", toArray);


        Map<String, Integer> toMap = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(Collectors.toMap(
                Function.identity(),
                s -> (int) s.chars().distinct().count()
            ));

        print("toMap", toMap);

        int sum = IntStream.of(1, 2, 3).sum();
        print("sum", sum);
        OptionalDouble average = IntStream.of(1, 2, 3).average();
        print("average", average);
        int max = IntStream.of(1, 2, 3).max().orElse(0);
        print("max", max);
        IntSummaryStatistics statistics = IntStream.of(1, 2, 3).summaryStatistics();
        print("statistics", statistics);
        boolean containsTwo = IntStream.of(1, 2, 3).anyMatch(i -> i == 2);
        print("containsTwo", containsTwo);


        Optional<String> reduce = Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .reduce((result, element) -> result.charAt(0) >= element.charAt(0) ? result : element);

        print("reduce", reduce);

        Map<Character, List<String>> groupingByList =  Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            // Apply this Classifier
            .collect(Collectors.groupingBy(
                s -> s.charAt(0) //Classifier
            ));

        print("groupingByList", groupingByList);

        Map<Character, Long> groupingByCounting =  Stream.of(
            "One", "Two", "Three", "Thirteen"
        )
            .collect(Collectors.groupingBy(
                s -> s.charAt(0), // Classifier
                counting()        // Downstream collector
            ));

        print("groupingByCounting", groupingByCounting);

    }

    static void print(String msg, Object o) {
        final String s;
        if (o.getClass().isArray()) {
            s = Arrays.toString((Object[]) o);
        } else {
            s = o.toString();
        }
        System.out.format("%s: %s%n", msg, s);
    }

}
