package com.speedment.example.solution;

import com.speedment.example.unit.Unit1Create;

import java.io.IOException;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Unit1MyCreate implements Unit1Create {

    @Override
    public Stream<String> newStreamOfAToC() {
        return Stream.empty();
    }

    @Override
    public IntStream newIntStreamOfOneToSeven() {
        return IntStream.empty();
    }

    @Override
    public Stream<String> from(String[] array) {
        return Stream.empty();
    }

    @Override
    public Stream<String> from(Collection<String> collection) {
        return Stream.empty();
    }

    @Override
    public IntStream from(String s) {
        return IntStream.empty();
    }

    @Override
    public IntStream infiniteAlternating() {
        return IntStream.empty();
    }

    @Override
    public IntStream infiniteRandomInts(Random rnd) {
        return IntStream.empty();
    }

    @Override
    public Stream<String> linesFromPoemTxtFile() throws IOException {
        return Stream.empty();
    }
}
