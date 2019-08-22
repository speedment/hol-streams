package com.speedment.example.unit;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface IntermediateUnit {

    /**
     * Return a Stream that contains words that are longer than
     * three characters. Shorter words (i.g. words of length 0, 1, 2 and 3)
     * shall be filtered away from the stream.
     * <p>
     *  A Stream of
     *      ["The", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
     *  would produce a Stream of the elements
     *      ["quick", "quick", "brown", "jumps", "over", "lazy"]
     *
     * @param stream input of words
     * @return a Stream that contains words that are longer than
     *         three characters.
     */
    Stream<String> wordsLongerThanThreeChars(Stream<String> stream);

    /**
     * Return a Stream that contains the first two words that are longer than
     * three characters. Shorter words (i.g. words of length 0, 1, 2 and 3)
     * shall be filtered away from the stream.
     * <p>
     *  A Stream of
     *      ["The", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
     *  would produce a Stream of the elements
     *      ["quick", "quick"]
     *
     * @param stream input of words
     * @return a Stream that contains the first two words that are longer than
     *         three characters.
     */
    Stream<String> firstTwoWordsLongerThanThreeChars(Stream<String> stream);

    /**
     * Return a Stream that contains the first two distinct words words that are longer than
     * three characters sorted in alphabetical order. Shorter words
     * (i.g. words of length 0, 1, 2 and 3)shall be filtered away from the stream.
     * <p>
     *  A Stream of
     *      ["The", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
     *  would produce a Stream of the elements
     *      ["brown", "quick"]
     *
     * @param stream input of words
     * @return that contains the first two distinct words words that are longer than
     *         three characters sorted in alphabetical order
     */
    Stream<String> firstDistinctTwoWordsLongerThanThreeCharsInAlphabeticOrder(Stream<String> stream);

    /**
     * Return a new IntStream that contains the length of the elements
     * in the provided input Stream.
     * <p>
     *  A Stream of
     *      ["The", "quick", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"]
     *  would produce an IntStream of the elements
     *      [3, 5, 5, 5, 3, 4, 4, 3, 4, 3]
     *
     * @param stream input of words
     * @return new IntStream that contains the length of the elements
     *         in the provided input Stream
     */
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

    /**
     * Returns a Stream which contains only elements that are of type String.
     * <P>
     *  A Stream of
     *      ["First", 21, new Random(42), new ArrayList<>(), "Last"]
     *  would produce a Stream of the elements
     *      ["First", "Last"]
     *
     * @param stream input of objects
     * @return a Stream which contains only elements that are of type String
     */
    Stream<String> strings(Stream<Object> stream);

}
