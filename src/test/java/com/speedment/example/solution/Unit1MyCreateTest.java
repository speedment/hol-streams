package com.speedment.example.solution;

import com.speedment.example.unit.Unit1Create;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.toList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Unit1MyCreateTest {

    private final Unit1Create instance = new Unit1MyCreate();

    @Test
    @Order(0)
    void newStreamOfAToC() {
        tester(
            instance,
            Stream.of("A", "B", "C"),
            Unit1Create::newStreamOfAToC,
            s -> s.collect(toList())
        );
    }

    @Test
    @Order(1)
    void intStreamOfOneToSeven() {
        tester(
            instance,
            IntStream.of(1, 2, 3, 4, 5, 6, 7),
            Unit1Create::newIntStreamOfOneToSeven,
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    @Order(2)
    void fromArray() {
        final String[] texts = {"Alpha", "Bravo", "Charlie"};
        tester(
            instance,
            Stream.of(texts),
            i -> i.from(texts),
            s -> s.collect(toList())
        );
    }

    @Test
    @Order(3)
    void fromCollection() {
        final List<String> texts = Arrays.asList("Alpha", "Bravo", "Charlie");
        tester(
            instance,
            texts.stream(),
            i -> i.from(texts),
            s -> s.collect(toList())
        );
    }

    @Test
    @Order(4)
    void fromString() {
        final String text = "Banana";
        tester(
            instance,
            text.chars(),
            i -> i.from(text),
            s -> s.boxed().collect(toList())
        );
    }


    @Test
    @Order(5)
    void infiniteAlternating() {
        final long limit = 19;
        tester(
            instance,
            IntStream.iterate(1, i -> -1 * i).limit(limit),
            i -> i.infiniteAlternating().limit(limit),
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    @Order(6)
    void infiniteRandomInts() {
        final int seed = 42;
        final long limit = 19;
        tester(
            instance,
            new Random(seed).ints().limit(limit),
            i -> i.infiniteRandomInts(new Random(seed)).limit(limit),
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    @Order(7)
    void linesFromPoemTxtFile() {
        tester(
            instance,
            expectedLinesFromPoemTxtFile() ,
            i -> {
                try {
                    return i.linesFromPoemTxtFile();
                } catch (IOException ignore) {
                    throw new RuntimeException(ignore);
                }
            },
            s -> s.collect(toList())
        );
        expectedLinesFromPoemTxtFile().forEach(System.out::println);
    }

    private Stream<String> expectedLinesFromPoemTxtFile() {
        try {
            return Files.lines(Paths.get(Unit1Create.FILE_NAME));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}