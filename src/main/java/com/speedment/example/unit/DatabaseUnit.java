package com.speedment.example.unit;

import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.Actor;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.runtime.core.Speedment;
import com.speedment.runtime.join.JoinComponent;

import java.util.List;
import java.util.Map;

public interface DatabaseUnit {

    /**
     * Returns a FilmManager that can be used to
     * obtain Streams from the database table "film".
     *
     * @param speedment instance to use
     * @return a FilmManager that can be used to
     *         obtain Streams from the database table "film"
     */
    FilmManager films(Speedment speedment);


    /**
     * Returns the total number of films in the database.
     *
     * @param films manager of film entities
     * @return the total number of films in the database
     */
    long countAllFilms(FilmManager films);


    /**
     * Returns the number of films in the database
     * that has a Film.RATING equal to "PG-13".
     *
     * @param films manager of film entities
     * @return the number of films in the database
     *         that has a Film.RATING equal to "PG-13"
     */
    long countPg13Films(FilmManager films);

    /**
     * Creates and returns a new List of five Film
     * entities that has a Film.LENGTH greater than 120 minutes.
     *
     * @param films manager of film entities
     * @return a
     */
    List<Film> fiveLongFilms(FilmManager films);


    List<Film> secondPageOf20OrderByTitle(FilmManager films);

    Map<String, Long> frequencyTableOfRating(FilmManager films);


    Map<Actor, Long> actorToFilmCount(JoinComponent joinComponent);


}
