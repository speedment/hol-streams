package com.speedment.example.solution;

import com.speedment.example.unit.Unit2Intermediate;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Unit2MyIntermediate implements Unit2Intermediate {

    @Override
    public Stream<String> wordsLongerThanThreeChars(Stream<String> stream) {
        return Stream.empty();
    }

    @Override
    public Stream<String> firstTwoWordsLongerThanThreeChars(Stream<String> stream) {
        return Stream.empty();
    }

    @Override
    public Stream<String> firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream) {
        return Stream.empty();
    }

    @Override
    public IntStream lengthOfWords(Stream<String> stream) {
        return IntStream.empty();
    }

    @Override
    public IntStream increasingSawtooth() {
        return IntStream.empty();
    }

    @Override
    public Stream<String> strings(Stream<Object> stream) {
        return Stream.empty();
    }
}
