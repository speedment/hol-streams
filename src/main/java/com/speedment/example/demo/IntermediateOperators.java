package com.speedment.example.demo;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class IntermediateOperators {

    public static void main(String[] args) {

        Stream<String> startsWithT = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .filter(s -> s.startsWith("L"));

        print("startsWithL", startsWithT);

        Stream<String> firstTwoStartsWithT = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .filter(s -> s.startsWith("L"))
            .limit(2);

        print("firstTwoStartsWithL", firstTwoStartsWithT);

        Stream<String> alphabeticOrder = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .sorted();

        print("alphabeticOrder", alphabeticOrder);

        Stream<String> lengthOrder = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .sorted(Comparator.comparing(String::length));

        print("lengthOrder", lengthOrder);

        Stream<String> lowerCase = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .map(String::toLowerCase);

        print("lowerCase", lowerCase);

        IntStream lengths = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .mapToInt(String::length);

        print("lengths", lengths);

        IntStream uniqueChars = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .mapToInt(s -> (int) s.chars().distinct().count());

        print("uniqueChars", uniqueChars);

        Stream<Character> chars = Stream.of(
            "Monkey", "Lion", "Giraffe", "Lemur"
        )
            .flatMap(s -> s.chars().mapToObj(i -> (char) i));

        print("chars", chars);

        Stream<Integer> integerStream = IntStream.range(0, 10).boxed();

        print("integerStream", integerStream);

    }

    private static void print(String msg, IntStream intStream) {
        print(msg, intStream.boxed());
    }

    private static void print(String msg, Stream<?> stream) {
        System.out.format("%s: %s%n", msg, stream.collect(toList()));
    }

}
