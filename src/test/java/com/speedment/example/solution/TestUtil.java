package com.speedment.example.solution;

import java.util.List;
import java.util.function.Function;
import java.util.stream.BaseStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

final class TestUtil {
    private TestUtil() {}

    /**
     * Tests a stream of any kind against a reference stream of the same type.
     *
     * @param instance from which to extract the stream
     * @param referance stream
     * @param creator to apply when creating a new stream
     * @param collector  to apply to the two streams -> List
     * @param <I> Type of the instance from which streams are obtained
     * @param <T> Elements in the stream
     * @param <S> Stream type, E.g. Stream<String> or IntStream
     */
    static <I, T, S extends BaseStream> void tester(
        final I instance,
        final S referance,
        final Function<I, S> creator,
        final Function<S, List<T>> collector
    ) {

        final S stream = creator.apply(instance);

        // Make sure that the streams have the same parallel property
        assertEquals(referance.isParallel(), stream.isParallel());

        // Make sure that streams are not reused
        assertNotSame(creator.apply(instance) , stream);

        // Make sure that the streams have the same content
        final List<T> expected = collector.apply(referance);
        final List<T> actual = collector.apply(stream);
        assertEquals(expected, actual);

        System.out.format("The stream content was %s%n", expected);
    }


}
