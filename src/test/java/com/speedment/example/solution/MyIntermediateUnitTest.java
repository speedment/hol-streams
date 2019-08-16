package com.speedment.example.solution;

import com.speedment.example.unit.IntermediateUnit;
import org.junit.jupiter.api.Test;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

final class MyIntermediateUnitTest {

    private static final List<String> WORDS = Arrays.asList(
            "A",
            "a",
            "letter",
            "box",
            "letter",
            "is",
            "frequently",
            "farther",
            "away",
            "than",
            "expected",
            "letter"
        );

    private final IntermediateUnit instance = new MyIntermediateUnit();

    @Test
    void wordsLongerThanThreeChars() {
        tester(
            instance,
            WORDS.stream().filter(s -> s.length() > 3),
            i -> i.wordsLongerThanThreeChars(WORDS.stream()),
            s -> s.collect(toList())
        );
    }


    @Test
    void strings() {
        final List<Object> OBJECTS = Arrays.asList(new Object(), 1, 2L, 3f, "Bill", new Random(), "Smith", new ArrayList());
        tester(
            instance,
            OBJECTS.stream().filter(String.class::isInstance).map(String.class::cast),
            i -> i.strings(OBJECTS.stream()),
            s -> s.collect(toList())
        );
    }



}