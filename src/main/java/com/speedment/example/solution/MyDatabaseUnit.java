package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.unit.DatabaseUnit;
import com.speedment.runtime.core.Speedment;

public class MyDatabaseUnit implements DatabaseUnit {

    @Override
    public long countFilms(Speedment speedment) {
        FilmManager films = speedment.getOrThrow(FilmManager.class);
        return films.stream().count();
    }
}
