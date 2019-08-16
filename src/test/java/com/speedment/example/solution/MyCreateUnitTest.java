package com.speedment.example.solution;

import com.speedment.example.unit.CreateUnit;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.toList;

final class MyCreateUnitTest {

    private final CreateUnit instance = new MyCreateUnit();

    @Test
    void newStreamOfAToC() {
        tester(
            instance,
            Stream.of("A", "B", "C"),
            CreateUnit::newStreamOfAToC,
            s -> s.collect(toList())
        );
    }

    @Test
    void intStreamOfOneToTen() {
        tester(
            instance,
            IntStream.of(0, 1, 2, 3, 4, 5, 6, 7),
            CreateUnit::newIntStreamOfOneToSeven,
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    void linesFromPoemTxtFile() {
        tester(
            instance,
            expectedLinesFromPoemTxtFile() ,
            CreateUnit::linesFromPoemTxtFile,
            s -> s.collect(toList())
        );
        expectedLinesFromPoemTxtFile().forEach(System.out::println);
    }

    private Stream<String> expectedLinesFromPoemTxtFile() {
        try {
            return Files.lines(Paths.get("poem.txt"));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

}