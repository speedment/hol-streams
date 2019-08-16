package com.speedment.example.unit;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface IntermediateUnit {

    Stream<String> wordsLongerThanThreeChars(Stream<String> stream);

    Stream<String> firstFiveWordsLongerThanThreeChars(Stream<String> stream);

    Stream<String> firstDistinctFiveWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream);

    IntStream lengthOfWords(Stream<String> stream);

    /**
     * Creates and returns a new IntStream with the following elements:
     *
     * 0
     * 0 1
     * 0 1 2
     * 0 1 2 3
     * 0 1 2 3 4
     * ....
     * 0 ..... Integer.MAX_VALUE
     *
     * @return a new IntStream with the following elements
     */
    IntStream increasingSawtooth();

    Stream<String> strings(Stream<Object> stream);



}
