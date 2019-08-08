package com.speedment.example.task;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface StreamCreator {

    /**
     * Creates a new Stream of String objects that contains the elements
     * "A", "B" and "C" in order.
     *
     * @return a new Stream of String objects that contains the elements
     *         "A", "B" and "C" in order
     */
    Stream<String> newStreamOfAToC();


    /**
     * Creates a new IntStream that contains the int elements
     * from zero (inclusive) to seven (inclusive) in order.
     *
     * @return a new IntStream that contains the int elements
     *         from zero (inclusive) to seven (inclusive) in order
     */
    IntStream newIntStreamOfOneToSeven();

}
