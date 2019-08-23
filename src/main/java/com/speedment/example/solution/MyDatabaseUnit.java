package com.speedment.example.solution;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.example.unit.DatabaseUnit;
import com.speedment.runtime.core.Speedment;
import com.speedment.runtime.join.Join;
import com.speedment.runtime.join.JoinComponent;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public final class MyDatabaseUnit implements DatabaseUnit {

    @Override
    public FilmManager films(Speedment speedment) {
        return speedment.getOrThrow(FilmManager.class);
    }

    @Override
    public long countAllFilms(FilmManager films) {
        return films.stream().count();
    }

    @Override
    public long countPg13Films(FilmManager films) {
        return films.stream()
            .filter(Film.RATING.equal("PG-13"))
            .count();
    }

    @Override
    public List<Film> fiveLongFilms(FilmManager films) {
        return films.stream()
            .filter(Film.LENGTH.greaterThan(120))
            .limit(5)
            .collect(toList());
    }

    @Override
    public List<Film> secondPageOf20OrderByTitle(FilmManager films) {
        return films.stream()
            .sorted(Film.TITLE)
            .skip(20)
            .limit(20)
            .collect(toList());
    }

    @Override
    public Map<String, Long> frequencyTableOfRating(FilmManager films) {
        return films.stream()
            .collect(groupingBy(Film.RATING, counting()));
    }

    @Override
    public Map<Actor, Long> actorToFilmCount(JoinComponent joinComponent) {
        // This is a predefined JOIN which is given for the task at hand
        // This join can produce streams with Tuple3<FilmActor, Film, Actor> elements
        // The FilmActor can be extracted by invoking Tuple3::get0
        // The Film can be extracted by invoking Tuple3::get1
        // The Actor can be extracted by invoking Tuple3::get2
        Join<Tuple3<FilmActor, Film, Actor>> join = joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build(Tuples::of);

        return join.stream()
            .collect(
                groupingBy(Tuple3::get2, counting())
            );
    }

    /*

    @Override
    public List<Film> longFilms(FilmManager films) {
        return films.stream()
            .filter(Film.LENGTH.greaterThan(120))
            .collect(toList());
    }*/

}
