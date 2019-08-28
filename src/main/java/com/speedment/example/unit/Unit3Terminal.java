package com.speedment.example.unit;

import java.util.*;
import java.util.stream.Stream;

public interface Unit3Terminal {

    // Do Stuff

    /**
     * Adds each element in the provided Stream
     * to the provided Set.
     * <p>
     * An input stream of ["A", "B", "C"] and an
     * empty input Set will modify the input Set
     * to contain : ["A", "B", "C"]
     *
     * @param stream with input elements
     * @param set to add elements to
     */
    void addToSet(Stream<String> stream, Set<String> set);

    /**
     * Adds each element in the provided Stream to the provided List
     * in order of appearance.
     *
     * @param stream with input elements
     * @param list to add elements to
     */
    void addToListInOrder(Stream<String> stream, List<String> list);


    // Convert to collections and others

    /**
     * Creates and returns a new Set that contains
     * the elements in the provided Stream.
     * <p>
     * An input stream of
     *     ["A", "B", "C"]
     * will produce a Set with the elements
     *     ["A", "B", "C"]
     *
     * @param stream with input elements
     */
    Set<String> collectToSet(Stream<String> stream);

    /**
     * Creates and returns a new List that contains
     * the elements in the provided Stream in order of
     * appearance.
     * <p>
     * An input stream of
     *     ["A", "B", "C"]
     * will produce a List with the elements
     *     ["A", "B", "C"]
     *
     * @param stream with input elements
     */
    List<String> collectToList(Stream<String> stream);

    /**
     * Creates and returns a new String with the elements in the
     * provided input stream joined together and separated with
     * the string "->".
     * <p>
     * An input stream of
     *     ["Edit", "Search", "Search and Replace"]
     * would produce the String
     *     "Edit->Search->Search and Replace".
     *
     * @param stream with input elements
     * @return a new String with the elements in the
     *         provided input stream joined together and separated with
     *         the string "->"
     */
    String collectJoining(Stream<String> stream);

    /**
     * Creates and returns a new Array of Strings that contains
     * the elements in the provided Stream in order of
     * appearance.
     * <p>
     * An input stream of
     *     ["A", "B", "C"]
     * will produce an array with the elements
     *     ["A", "B", "C"]
     *
     * @param stream with input elements
     */
    String[] toArray(Stream<String> stream);

    /**
     * Creates and returns a new Map with Strings as key and
     * integers as values where the the keys are identical to the
     * elements in the input stream and the values are the number of
     * characters in the corresponding key.
     * <p>
     * An input stream of ["Beatles", "Abba"] would produce the
     * following map : {"Beatles"=7, "Abba"=4}
     *
     * @param stream with input elements
     * @return a new Map with Strings as key and
     *         integers as values where the the keys are identical to the
     *         elements in the input stream and the values are the number of
     *         characters in the corresponding key
     */
    Map<String, Integer> collectToMap(Stream<String> stream);

    // Summarization

    /**
     * Returns the sum of all characters in the words in the input Stream.
     * If there are no elements in the input stream, the method shall return
     * zero.
     * <p>
     * An input Stream of ["The", "rain", "in", "Spain", "stays"] would produce
     * an output of 3 + 4 + 2 + 5 + 5 = 19
     *
     * @param stream with input elements
     * @return the sum of all characters in the words in the input Stream
     */
    int countCharacters(Stream<String> stream);

    /**
     * Returns the length of the the longest word in the input Stream.
     * If there are no elements in the input stream, the method shall return
     * zero.
     * <p>
     * An input Stream of ["The", "rain", "in", "Spain", "stays"] would produce
     * an output of 5 (i.e. "Spain".length() is 5)
     *
     * @param stream with input elements
     * @return the sum of all characters in the words in the input Stream
     */
    int maxWordLen(Stream<String> stream);

    /**
     * Returns the IntSummaryStatistics of the length of the elements in
     * the input Stream.
     * <p>
     * An input Stream of ["The", "rain", "in", "Spain", "stays"] would produce
     * an output of IntSummaryStatistics{count=5, sum=19, min=2, average=3.800000, max=5}
     *
     * @param stream with input elements
     * @return the sum of all characters in the words in the input Stream
     */
    IntSummaryStatistics statistics(Stream<String> stream);


    // Map/Reduce

    /**
     * Returns the first longest String element in the provided Stream
     * or Optional.empty() if there are no elements in the Stream.
     * <p>
     * An input Stream of ["The", "rain", "in", "Spain", "stays"] would produce
     * an output of Optional.of("Spain")
     *
     * @param stream with input elements
     * @return the first longest String element in the provided Stream
     *         or Optional.empty() if there are no elements in the Stream
     */
    Optional<String> findLongestString(Stream<String> stream);


    // Grouping

    /**
     * Creates and returns a new Map with words from the provided input Stream
     * grouped by length.
     * <p>
     * An input Stream of ["The", "rain", "in", "Spain", "stays"] would produce
     * an output of {
     *     2 = ["in"],
     *     3 = ["The"],
     *     4 = ["rain"],
     *     5 = ["Spain", "stays"]
     * }
     *
     * @param stream with input elements
     * @return a new Map with words from the provided input Stream
     *         grouped by length
     */
    Map<Integer, List<String>> wordsGroupedByLength(Stream<String> stream);

    /**
     * Creates and returns a new Map with words from the provided input Stream
     * grouped by length counting each group's elements. This is equivalent to
     * computing the frequency table of word lengths.
     * <p>
     * An input Stream of ["The", "rain", "in", "Spain", "stays"] would produce
     * an output of {
     *     2 = 1,
     *     3 = 1,
     *     4 = 1,
     *     5 = 2]
     * }
     *
     * @param stream with input elements
     * @return a new Map with words from the provided input Stream
     *         grouped by length counting each group's elements
     */
    Map<Integer, Long> wordsGroupedByLengthCounted(Stream<String> stream);

}
