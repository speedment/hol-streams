package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.unit.Unit4Database;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

public final class Unit4MyDatabase implements Unit4Database {

    @Override
    public long countAllFilms(FilmManager films) {
        return 0;
    }

    @Override
    public long countPg13Films(FilmManager films) {
        return 0;
    }

    public List<Film> tenKidsFilms(FilmManager films) {
        return emptyList();
    }

    @Override
    public List<String> fiveLongFilms(FilmManager films) {
        return emptyList();
    }

    @Override
    public List<Film> filmsSortedByTitleThirdPage(FilmManager films) {
        return emptyList();
    }

    @Override
    public Map<String, Long> frequencyTableOfRating(FilmManager films) {
        return emptyMap();
    }

}
