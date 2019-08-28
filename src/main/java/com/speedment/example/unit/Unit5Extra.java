package com.speedment.example.unit;

import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.runtime.join.JoinComponent;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public interface Unit5Extra {

    Map<Actor, Long> actorToFilmCount(JoinComponent joinComponent);

    /**
     * Creates and returns a new Map with Actors as keys and
     * a List of Films in which they appear as values.
     * <p>
     * The result might look like this:
     *
     * ActorImpl { actorId = 126, firstName = FRANCES, lastName = TOMEI, ... }=[FilmImpl { filmId = 21, title = AMERICAN CIRCUS, ...}, ...]
     * ActorImpl { actorId = 77, firstName = CARY, lastName = MCCONAUGHEY, ... }=[FilmImpl { filmId = 13, title = ALI FOREVER, ...}, ...]
     * ActorImpl { actorId = 140, firstName = WHOOPI, lastName = HURT, ... }=[FilmImpl { filmId = 27, title = ANONYMOUS HUMAN, ...}, ...]
     * ...
     *
     * @param joinComponent for data input
     * @return a new Map with Actors as keys and
     *         a List of Films in which they appear as values
     */
    Map<Actor, List<Film>> filmographies(JoinComponent joinComponent);

    /**
     * Creates and returns a new Map with Actors' last name as keys and
     * a List of Film titles in which they appear as values.
     *
     * <P>
     * The result might look like this:
     *
     * AKROYD=[BACKLASH UNDEFEATED, BETRAYED REAR, CAPER MOTIONS, ...]
     * PRESLEY=[BILKO ANONYMOUS, CARIBBEAN LIBERTY, CASPER DRAGONFLY, ...]
     * MCQUEEN=[AMADEUS HOLY, ARABIA DOGMA, BONNIE HOLOCAUST, ...]
     * ...
     *
     * @param joinComponent for data input
     * @return a new Map with Actors' last name as keys and
     *         a List of Film titles in which they appear as values
     */
    Map<String, List<String>> filmographiesNames(JoinComponent joinComponent);

    /**
     * Creates and returns a new Map with Actors as keys and values as a
     * Map with ratings as keys and values as the number of films
     * with that rating they have appeared.
     * <p>
     * The result might look like this:
     *
     * ActorImpl { actorId = 126, firstName = FRANCES, lastName = TOMEI, ... }={PG-13=4, R=6, NC-17=1, PG=6, G=6}
     * ActorImpl { actorId = 77, firstName = CARY, lastName = MCCONAUGHEY, ... }={PG-13=6, R=5, NC-17=2, G=6, PG=5}
     * ActorImpl { actorId = 140, firstName = WHOOPI, lastName = HURT, ... }={PG-13=4, R=9, NC-17=7, PG=8, G=4}
     * ...
     *
     * @param joinComponent for data input
     * @return a new Map with Actors as keys and values as a
     *         Map with ratings as keys and values as the number of films
     *         with that rating they have appeared
     */
    Map<Actor, Map<String, Long>> pivot(JoinComponent joinComponent);

    /**
     * Creates and returns a new LongStream with the
     * first 21 factorial numbers.
     * <p>
     * 0!, 1!, 2! .. 20!:
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
    LongStream factorials();

    /**
     * Creates and returns an infinite Stream of BigInteger
     * factorial numbers.
     * <p>
     * The solution must be O(n) where n is the number of factorial
     * numbers generated. Thus, no iteration with a .flatMap()
     * with an inner stream can be used.
     * <p>
     * 0!, 1!, 2! ...
     *         1,
     *         1,
     *         2,
     *         6,
     *         24,
     *         120,
     *         ...
     *<p>
     *
     * @return an infinite Stream of BigInteger
     *         factorial numbers.
     */
    Stream<BigInteger> bigFactorials();

}
