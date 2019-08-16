package com.speedment.example.unit;

import com.speedment.common.tuple.Tuple2;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;

import java.io.File;
import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface ExtraUnit {

    /*Stream<Film> longestPg13Films();*/

    /**
     * Creates and returns a new LongStream with the
     * first 21 factorial numbers 0!, 1!, 2! .. 20!:
     *         1L,
     *         1L,
     *         2L,
     *         6L,
     *         24L,
     *         120L,
     *         ...
     *         2432902008176640000L
     *<p>
     * NB: 20! is the largest factorial number that fits in a long
     *
     * @return a new LongStream with the
     *         first 21 factorial numbers
     */
    LongStream factorial();

    Stream<BigInteger> bigFactorial();

    /**
     * Creates and returns a new IntStream with the
     * prime numbers:
     *         1L,
     *         1L,
     *         2L,
     *         6L,
     *         24L,
     *         120L,
     *         ...
     *
     * @return a new LongStream with the
     *         factorial numbers
     */
    IntStream primes();

    Stream<File> filesInTheCurrentDirectoryOrderBySize();





}
