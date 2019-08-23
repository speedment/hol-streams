package com.speedment.example.solution;

import com.speedment.example.unit.IntermediateUnit;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class MyIntermediateUnitTest {

    private static final List<String> WORDS = Arrays.asList(
        "The", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"
        );

    private final IntermediateUnit instance = new MyIntermediateUnit();

    @Test
    @Order(0)
    void wordsLongerThanThreeChars() {
        tester(
            instance,
            WORDS.stream().filter(s -> s.length() > 3),
            i -> i.wordsLongerThanThreeChars(WORDS.stream()),
            s -> s.collect(toList())
        );
    }

    @Test
    @Order(1)
    void firstTwoWordsLongerThanThreeChars() {
        tester(
            instance,
            WORDS.stream().filter(s -> s.length() > 3).limit(2),
            i -> i.firstTwoWordsLongerThanThreeChars(WORDS.stream()),
            s -> s.collect(toList())
        );
    }

    @Test
    @Order(2)
    void firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder() {
        tester(
            instance,
            WORDS.stream().filter(s -> s.length() > 3).distinct().limit(2).sorted(),
            i -> i.firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder(WORDS.stream()),
            s -> s.collect(toList())
        );
    }

    @Test
    @Order(3)
    void lengthOfWords() {
        tester(
            instance,
            WORDS.stream().mapToInt(String::length),
            i -> i.lengthOfWords(WORDS.stream()),
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    @Order(4)
    void increasingSawtooth() {
        final long limit = 15;
        tester(
            instance,
            IntStream.range(0, Integer.MAX_VALUE).flatMap(i -> IntStream.range(0, i)).limit(limit),
            i -> i.increasingSawtooth().limit(limit),
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    @Order(5)
    void strings() {
        final List<Object> OBJECTS = Arrays.asList("First", 21, new Random(42), new ArrayList<>(), "Last");
        tester(
            instance,
            OBJECTS.stream().filter(String.class::isInstance).map(String.class::cast),
            i -> i.strings(OBJECTS.stream()),
            s -> s.collect(toList())
        );
    }

}