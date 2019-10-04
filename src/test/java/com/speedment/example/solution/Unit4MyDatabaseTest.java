package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.sakila.sakila.film.Film;
import com.speedment.example.unit.Unit4Database;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.speedment.example.solution.TestUtil.tester;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
final class Unit4MyDatabaseTest extends AbstractDatabaseUnitTest {

    private final Unit4Database instance = new Unit4MyDatabase();

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
    @Order(3)
    void tenKidsFilms() {
        final Set<Film> candidates = films.stream().filter(Film.RATING.equal("G")).collect(Collectors.toSet());
        final List<Film> actual = instance.tenKidsFilms(films);
        assertEquals(10, actual.size(), "The list contained " + actual.size() + " elements");
        assertTrue(candidates.containsAll(actual));
        System.out.format("The database contained %d kids films, some of these were: %s%n", candidates.size(), actual);
    }

    @Test
    @Order(4)
    void fiveLongFilms() {
        final Set<String> candidates = films.stream().filter(Film.LENGTH.greaterThan(120)).map(Film.TITLE).collect(Collectors.toSet());
        final List<String> actual = instance.fiveLongFilms(films);
        assertEquals(5, actual.size());
        assertTrue(candidates.containsAll(actual));
        System.out.format("The database contained %d long films, some of these were: %s%n", candidates.size(), actual);
    }

    @Test
    @Order(5)
    void filmsSortedByLengthThirdPage() {
        final List<Film> expected = films.stream().sorted(Film.LENGTH).skip(20).limit(10).collect(Collectors.toList());
        final List<Film> actual = instance.filmsSortedByLengthThirdPage(films);
        tester(expected, actual);
    }

    @Test
    @Order(6)
    void frequencyTableOfRating() {
        final Map<String, Long> expected = films.stream().collect(groupingBy(
                 Film.RATING,
                 counting()
            )
        );
        final Map<String, Long> actual = instance.frequencyTableOfRating(films);
        tester(expected, actual);
    }


}