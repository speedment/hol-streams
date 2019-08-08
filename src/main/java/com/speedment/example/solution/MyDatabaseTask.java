package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.task.DatabaseTask;
import com.speedment.runtime.core.Speedment;

public class MyDatabaseTask implements DatabaseTask {

    @Override
    public long countFilms(Speedment speedment) {
        FilmManager films = speedment.getOrThrow(FilmManager.class);
        return films.stream().count();
    }
}
