package com.speedment.example.solution;

import com.speedment.common.tuple.Tuple2;
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

        throw new UnsupportedOperationException();
    }

    @Override
    public Map<String, List<String>> filmographiesNames(JoinComponent joinComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Map<Actor, Map<String, Long>> pivot(JoinComponent joinComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public LongStream factorials() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Stream<BigInteger> bigFactorials() {
        throw new UnsupportedOperationException();
    }

}
