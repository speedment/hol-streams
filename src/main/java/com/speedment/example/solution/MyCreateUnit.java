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
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStream newIntStreamOfOneToSeven() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<String> from(String[] array) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<String> from(Collection<String> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStream infiniteAlternating() {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStream from(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStream infiniteRandomInts(Random rnd) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<String> linesFromPoemTxtFile() {
        throw new UnsupportedOperationException();
    }
}
