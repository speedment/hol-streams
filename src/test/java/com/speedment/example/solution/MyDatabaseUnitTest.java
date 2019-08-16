package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.SakilaApplicationBuilder;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.unit.DatabaseUnit;
import com.speedment.runtime.core.Speedment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
final class MyDatabaseUnitTest {

    private final DatabaseUnit instance = new MyDatabaseUnit();
    private Speedment speedment;
    private FilmManager films;

    @BeforeAll
    void setup() {
        speedment = new SakilaApplicationBuilder()
            .withPassword("sakila")
            .build();
        films = speedment.getOrThrow(FilmManager.class);
    }

    @AfterAll
    void shutDown() {
        films = null;
        speedment.close();
    }

    @Test
    void countFilms() {
        final long expected = films.stream().count();
        final long actual = instance.countFilms(speedment);
        assertEquals(expected, actual);
        System.out.format("The database contained %d films.%n", expected);
    }


}