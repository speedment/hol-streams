package com.speedment.example.solution;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.example.unit.Unit5Extra;
import com.speedment.runtime.join.Join;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Unit5MyExtraTest extends AbstractDatabaseUnitTest {

    private final Unit5Extra instance = new Unit5MyExtra();

    @Test
    @Order(0)
    void actorToFilmCount() {
        final Join<Tuple3<FilmActor, Film, Actor>> join = joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build(Tuples::of);

        final Map<Actor, Long> expected = join.stream()
            .collect(
                groupingBy(Tuple3::get2, counting())
            );

        tester(expected, instance.actorToFilmCount(joinComponent));
    }


    @Test
    @Order(1)
    void filmographies() {
        final Map<Actor, List<Film>> expected = join().stream()
            .collect(
                groupingBy(Tuple2::get1, // Applies Actor as classifier
                    mapping(
                        Tuple2::get0, // Extracts Film from the Tuple
                        toList() // Use a List collector for downstream aggregation.
                    )
                )
            );

        final Map<Actor, List<Film>> actual = instance.filmographies(joinComponent);
        actual.entrySet().stream().limit(3).forEach(e -> System.out.format("%s=%s%n", e.getKey(), e.getValue()));
        System.out.println("...");
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    void filmographiesNames() {
        final Map<String, List<String>> expected = join().stream()
            .collect(
                groupingBy(Tuple2.<Film, Actor>getter1().andThen(Actor::getLastName), // Applies Actor's last name as classifier
                    mapping(
                        Tuple2.<Film, Actor>getter0().andThen(Film::getTitle), // Extracts Film's title from the Tuple
                        toList() // Use a List collector for downstream aggregation.
                    )
                )
            );
        final Map<String, List<String>> actual = instance.filmographiesNames(joinComponent);
        actual.forEach((k, v) -> System.out.format("%s=%s%n", k, v));
        assertEquals(expected, actual);
    }

    /*
        // Alternate solution to above
        join().stream()
            .collect(
                groupingBy(t2 -> t2.get1().getLastName(), // Applies Actor's last name as classifier
                    mapping(
                        t2 -> t2.get0().getTitle(), // Extracts Film's title from the Tuple
                        toList() // Use a List collector for downstream aggregation.
                    )
                )
            );
    */



    @Test
    @Order(3)
    void pivot() {
        final Map<Actor, Map<String, Long>> expected = join().stream()
            .collect(
                groupingBy(
                    Tuple2::get1, // Applies Actor as classifier
                    groupingBy(
                        tu -> tu.get0().getRating().orElse("UNKNOWN"), // Applies rating as second level classifier
                        counting() // Counts the elements
                    )
                )
            );

        final Map<Actor, Map<String, Long>> actual = instance.pivot(joinComponent);
        actual.forEach((k, v) -> System.out.format("%s=%s%n", k, v));
        assertEquals(expected, actual);
    }


    // http://minborgsjavapot.blogspot.com/2015/07/java-8-master-permutations.html
    @Test
    @Order(10)
    void factorial() {
        tester(
            instance,
            IntStream.rangeClosed(1, 21).mapToLong(n -> LongStream.range(1, n).reduce(1, (a, b) -> a * b)),
            Unit5Extra::factorials,
            s -> s.boxed().collect(toList())
        );
    }

    @Test
    @Order(11)
    void bigFactorial() {
        final long limit = 100;
        tester(
            instance,
            bigFactorialsHelper().limit(limit),
            i -> i.bigFactorials().limit(limit),
            s -> s.collect(toList())
        );
    }

    private Stream<BigInteger> bigFactorialsHelperSlow() {
        return IntStream.iterate(1, a -> a + 1).mapToObj(n -> LongStream.range(1, n).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
    }

    private Stream<BigInteger> bigFactorialsHelper() {
        final AtomicReference<BigInteger> current = new AtomicReference<>(BigInteger.valueOf(1));
        return
            Stream.concat(
                Stream.of(BigInteger.ONE, BigInteger.ONE),
                IntStream.iterate(2, n -> n + 1)
                    .mapToObj(n ->
                        current.accumulateAndGet(BigInteger.valueOf(n), BigInteger::multiply)
                    )
            );
    }

    private Join<Tuple2<Film, Actor>> join() {
        return joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build((fa, f, a) -> Tuples.of(f, a)); // Apply a custom constructor, discarding FilmActor
    }



}