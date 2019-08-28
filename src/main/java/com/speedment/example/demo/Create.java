package com.speedment.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class Create {

    public static void main(String[] args) {

        List<String> list = Stream.of("Monkey", "Lion", "Giraffe", "Lemur")
            .filter(s -> s.startsWith("L"))
            .map(String::toUpperCase)
            .sorted()
            .collect(toList());

        System.out.println(list);

        // This will produce the following output:
        // [Three, Two]

        create();
    }

    private static void create() {
        {
            Stream<String> stream = Stream.of("Monkey", "Lion", "Giraffe", "Lemur");
            String[] array = {"Monkey", "Lion", "Giraffe", "Lemur"};
            Stream<String> stream2 = Stream.of(array);
        }

        {
            List<String> list = Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur");
            Stream<String> streamFromList = list.stream();

            Set<String> set =  new HashSet<>(Arrays.asList("Monkey", "Lion", "Giraffe", "Lemur"));
            Stream<String> streamFromSet = set.stream();
        }
        {
            Queue<Thread> queue = new PriorityQueue<>();
            // ...
            Stream<Thread> stream = queue.stream();
        }
        {
            try {
                Stream<String> lines = Files.lines(Paths.get("file.txt"));
            } catch (IOException ioe) {
                // Handle exception here
            }
        }
        {
            Stream.Builder<String> sb = Stream.builder();
            sb.add("One").add("Two");
            //...
            sb.add("OneHundredSixtyFour");
            Stream<String> stream = sb.build();
        }


        {
            IntStream oneTwoThree = IntStream.of(1, 2, 3);
            IntStream positiveSingleDigits = IntStream.rangeClosed(1, 9);
            IntStream powersOfTwo = IntStream.iterate(1, i -> i * 2);
            IntStream chars =  "ABC".chars();
            IntStream randomInts = new Random().ints();
        }




    }


}
