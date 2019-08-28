package com.speedment.example.demo;

import com.speedment.common.tuple.Tuple3;
import com.speedment.common.tuple.Tuples;
import com.speedment.example.domainmodel.sakila.SakilaApplicationBuilder;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.ActorManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.runtime.core.ApplicationBuilder;
import com.speedment.runtime.core.Speedment;
import com.speedment.runtime.join.Join;
import com.speedment.runtime.join.JoinComponent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public final class DatabaseStreams {

    public static void main(String[] args) {

        Speedment speedment = new SakilaApplicationBuilder()
            .withPassword("sakila")
            .withParam("db.mysql.collationName", "utf8mb4_general_ci")
            .withParam("db.mysql.binaryCollationName", "utf8mb4_bin")
            .withLogging(ApplicationBuilder.LogType.STREAM)
            .build();

        FilmManager films = speedment.getOrThrow(FilmManager.class);
        ActorManager actors = speedment.getOrThrow(ActorManager.class);
        FilmActorManager filmActors = speedment.getOrThrow(FilmActorManager.class);
        JoinComponent joinComponent = speedment.getOrThrow(JoinComponent.class);


        List<Film> allFilms = films.stream().collect(toList());

        Optional<Film> longestFilm = films.stream()
            .max(Film.LENGTH);

        TerminalOperators.print("longestFilm", longestFilm);

        long rFilmCount = films.stream()
            .filter(Film.RATING.equal("R"))
            .count();

        TerminalOperators.print("rFilmCount", rFilmCount);

        List<Film> threeShortFilms = films.stream()
            .filter(Film.LENGTH.lessOrEqual(50))
            .limit(3)
            .collect(toList());

        TerminalOperators.print("threeShortFilms", threeShortFilms);

        List<Film> filmsSortedByLengthPage2 = films.stream()
            .sorted(Film.LENGTH)
            .skip(25 * 1)
            .limit(25)
            .collect(toList());

        TerminalOperators.print("filmsSortedByLengthPage2", filmsSortedByLengthPage2);

        List<Film> filmsTitleStartsWithA = films.stream()
            .filter(Film.TITLE.startsWith("A"))
            .filter(f -> f.getTitle().startsWith("A"))
            .sorted(Film.LENGTH)
            .collect(Collectors.toList());

        TerminalOperators.print("filmsTitleStartsWithA", filmsTitleStartsWithA);

        Map<Short, Long> frequencyTableOfLength = films.stream()
            .collect(Collectors.groupingBy(
                Film.LENGTH.asShort(),
                counting()
            ));

        TerminalOperators.print("frequencyTableOfLength", frequencyTableOfLength);


        Join<Tuple3<FilmActor, Film, Actor>> join = joinComponent
            .from(FilmActorManager.IDENTIFIER)
            .innerJoinOn(Film.FILM_ID).equal(FilmActor.FILM_ID)
            .innerJoinOn(Actor.ACTOR_ID).equal(FilmActor.ACTOR_ID)
            .build(Tuples::of);

        Map<Film, Long> filmToNoActors = join.stream()
            .collect(
                groupingBy(Tuple3::get1, counting())
            );



        TerminalOperators.print("filmToNoActors", filmToNoActors);


    }


}
