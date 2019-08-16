package com.speedment.example.solution;

import com.speedment.example.unit.CreateUnit;
import com.speedment.example.unit.IntermediateUnit;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyIntermediateUnit implements IntermediateUnit {

    @Override
    public Stream<String> wordsLongerThanThreeChars(Stream<String> stream) {
        return stream
            .filter(s -> s.length() > 3);
    }

    @Override
    public Stream<String> firstFiveWordsLongerThanThreeChars(Stream<String> stream) {
        return wordsLongerThanThreeChars(stream)
            .limit(5);
    }

    @Override
    public Stream<String> firstDistinctFiveWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream) {
        return wordsLongerThanThreeChars(stream)
            .distinct()
            .limit(5)
            .sorted();
    }

    @Override
    public IntStream lengthOfWords(Stream<String> stream) {
        return stream.mapToInt(String::length);
    }

    @Override
    public IntStream increasingSawtooth() {
        return IntStream.range(0, Integer.MAX_VALUE)
            .flatMap(i -> IntStream.range(0, i));
    }

    @Override
    public Stream<String> strings(Stream<Object> stream) {
        return stream
            .filter(String.class::isInstance)
            .map(String.class::cast);
    }
}
