package com.speedment.example.solution;

import com.speedment.example.task.StreamCreator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

final class MyStreamCreatorTest {

    private final StreamCreator instance = new MyStreamCreator();

    @Test
    void newStreamOfAToC() {
        tester(
            instance,
            Stream.of("A", "B", "C"),
            StreamCreator::newStreamOfAToC,
            s -> s.collect(toList())
        );
    }

    @Test
    void intStreamOfOneToTen() {
        tester(
            instance,
            IntStream.of(0, 1, 2, 3, 4, 5, 6, 7),
            StreamCreator::newIntStreamOfOneToSeven,
            s -> s.boxed().collect(toList())
        );
    }
}