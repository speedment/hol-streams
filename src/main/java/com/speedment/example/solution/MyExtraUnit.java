package com.speedment.example.solution;

import com.speedment.common.tuple.Tuple2;
import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.example.unit.ExtraUnit;
import com.speedment.runtime.join.Join;
import com.speedment.runtime.join.JoinComponent;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public final class MyExtraUnit implements ExtraUnit {

    @Override
    public Map<Actor, List<Film>> filmographies(JoinComponent joinComponent) {
        Join<Tuple2<Film, Actor>> join = joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build((fa, f, a) -> Tuples.of(f, a)); // Apply a custom constructor, discarding FilmActor

        return join.stream()
            .collect(
                groupingBy(Tuple2::get1, // Applies Actor as classifier
                    mapping(
                        Tuple2::get0, // Extracts Film from the Tuple
                        toList() // Use a List collector for downstream aggregation.
                    )
                )
            );
    }

    @Override
    public Map<String, List<String>> filmographiesNames(JoinComponent joinComponent) {
        Join<Tuple2<Film, Actor>> join = joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build((fa, f, a) -> Tuples.of(f, a)); // Apply a custom constructor, discarding FilmActor




        return join.stream()
            .collect(
                groupingBy(Tuple2.<Film, Actor>getter1().andThen(Actor::getLastName), // Applies Actor's last name as classifier
                    mapping(
                        Tuple2.<Film, Actor>getter0().andThen(Film::getTitle), // Extracts Film's title from the Tuple
                        toList() // Use a List collector for downstream aggregation.
                    )
                )
            );

    }

    @Override
    public Map<Actor, Map<String, Long>> pivot(JoinComponent joinComponent) {
        Join<Tuple2<Film, Actor>> join = joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build((fa, f, a) -> Tuples.of(f, a)); // Apply a custom constructor, discarding FilmActor

        return join.stream()
            .collect(
                groupingBy(
                    Tuple2::get1, // Applies Actor as classifier
                    groupingBy(
                        tu -> tu.get0().getRating().orElse("UNKNOWN"), // Applies rating as second level classifier
                        counting() // Counts the elements
                    )
                )
            );
    }

    @Override
    public LongStream factorials() {
        return IntStream.rangeClosed(1, 21).mapToLong(n -> LongStream.range(1, n). reduce(1, (a, b) -> a * b));
    }

    @Override
    public Stream<BigInteger> bigFactorials() {
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


}
