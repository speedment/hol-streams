package com.speedment.example.solution;

import com.speedment.example.unit.IntermediateUnit;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class MyIntermediateUnit implements IntermediateUnit {

    @Override
    public Stream<String> wordsLongerThanThreeChars(Stream<String> stream) {
        return stream.filter(s -> s.length() > 3);
    }

    @Override
    public Stream<String> firstTwoWordsLongerThanThreeChars(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<String> firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStream lengthOfWords(Stream<String> stream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public IntStream increasingSawtooth() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<String> strings(Stream<Object> stream) {
        throw new UnsupportedOperationException();
    }
}
