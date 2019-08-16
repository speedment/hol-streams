package com.speedment.example.unit;

import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface CreateUnit {

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

    Stream<String> from(String[] array);

    Stream<String> from(Collection<String> collection);

    IntStream infiniteAlternating();

    IntStream from(String s);

    IntStream infiniteRandomInts();

    /**
     * Read all lines from the file poem.txt as a Stream.
     * Bytes from the file are decoded into characters using the UTF-8 charset.
     *
     * @return a
     */
    Stream<String> linesFromPoemTxtFile();

}
