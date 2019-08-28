package com.speedment.example.unit;

import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;

import java.util.List;
import java.util.Map;

public interface Unit4Database {

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
     * Creates and returns a List of ten films
     * for kids (e.g. with a that has a Film.RATING equal
     * to "G")
     *
     * @param films manager of film entities
     * @return the number of films in the database
     *         that has a Film.RATING equal to "G"
     */
    List<Film> tenKidsFilms(FilmManager films);

    /**
     * Creates and returns a new List of five Film.TITLE
     * Strings that has a Film.LENGTH greater than 120 minutes.
     *
     * @param films manager of film entities
     * @return a new List of five Film
     *         entities that has a Film.LENGTH
     *         greater than 120 minutes
     */
    List<String> fiveLongFilms(FilmManager films);

    /**
     * Creates and returns a new List of Films sorted by
     * Film.TITLE and just 10 films starting from the
     * 20:th film where the films are sorted by Film.TITLE.
     *
     * @param films manager of film entities
     * @return a
     */
    List<Film> filmsSortedByTitleThirdPage(FilmManager films);

    /**
     * Creates and returns a new Map with Film.RATING as keys and
     * number of film occurrences as values.
     * <p>
     * Tip: This is a groupingBy operation
     *
     * @param films manager of film entities
     * @return a new Map with Film.RATING as keys and
     *         number of film occurrences as values
     */
    Map<String, Long> frequencyTableOfRating(FilmManager films);


}
