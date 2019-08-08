package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.SakilaApplicationBuilder;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.task.DatabaseTask;
import com.speedment.example.task.StreamCreator;
import com.speedment.runtime.core.Speedment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.function.Function;
import java.util.stream.BaseStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
final class MyDatabaseTaskTest {

    private final DatabaseTask instance = new MyDatabaseTask();
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