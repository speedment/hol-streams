package com.speedment.example.solution;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.example.unit.DatabaseUnit;
import com.speedment.runtime.join.Join;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Map;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class MyDatabaseUnitTest extends AbstractDatabaseUnitTest {

    private final DatabaseUnit instance = new MyDatabaseUnit();

    @Test
    @Order(0)
    void films() {
        final FilmManager actual = instance.films(speedment);
        assertSame(films, actual);
        System.out.format("The manager can be used to stream content from the table %s.%s%n", actual.getTableIdentifier().getDbmsId(), actual.getTableIdentifier().getTableId());
    }

    @Test
    @Order(1)
    void countAllFilms() {
        final long expected = films.stream().count();
        final long actual = instance.countAllFilms(films);
        assertEquals(expected, actual);
        System.out.format("The database contained %d films.%n", actual);
    }

    @Test
    @Order(2)
    void countPg13Films() {
        final long expected = films.stream().filter(Film.RATING.equal("PG-13")).count();
        final long actual = instance.countPg13Films(films);
        assertEquals(expected, actual);
        System.out.format("The database contained %d films of rating PG-13.%n", actual);
    }


    @Test
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


}