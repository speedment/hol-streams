package com.speedment.example.domainmodel.sakila.demo;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public final class Basics {

    public static void main(String[] args) {

        List<String> list = Stream.of("One", "Two", "Three")
            .filter(s -> s.startsWith("T"))
            .map(String::toUpperCase)
            .sorted()
            .collect(toList());

        System.out.println(list);

        // This will produce the following output:
        // [Three, Two]


    }

}
