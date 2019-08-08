package com.speedment.example.solution;

import com.speedment.example.task.StreamCreator;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyStreamCreator implements StreamCreator {

    @Override
    public Stream<String> newStreamOfAToC() {
        return Stream.of("A", "B", "C");
    }

    @Override
    public IntStream newIntStreamOfOneToSeven() {
        return IntStream.range(0, 8);
    }
}
