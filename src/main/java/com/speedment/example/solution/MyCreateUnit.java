package com.speedment.example.solution;

import com.speedment.example.unit.CreateUnit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class MyCreateUnit implements CreateUnit {

    @Override
    public Stream<String> newStreamOfAToC() {
        return Stream.of("A", "B", "C");
    }

    @Override
    public IntStream newIntStreamOfOneToSeven() {
        return IntStream.range(1, 8);
    }

    @Override
    public Stream<String> from(String[] array) {
        return Stream.of(array);
    }

    @Override
    public Stream<String> from(Collection<String> collection) {
        return collection.stream();
    }

    @Override
    public IntStream infiniteAlternating() {
        return IntStream.iterate(1, l -> l * -1);
    }

    @Override
    public IntStream from(String s) {
        return s.chars();
    }

    @Override
    public IntStream infiniteRandomInts(Random rnd) {
        return rnd.ints();
    }

    @Override
    public Stream<String> linesFromPoemTxtFile() {
        try {
            return Files.lines(Paths.get(FILE_NAME));
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
