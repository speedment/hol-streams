package com.speedment.example.solution;

import com.speedment.example.domainmodel.sakila.SakilaApplicationBuilder;
import com.speedment.example.domainmodel.sakila.sakila.sakila.actor.ActorManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film.FilmManager;
import com.speedment.example.domainmodel.sakila.sakila.sakila.film_actor.FilmActorManager;
import com.speedment.runtime.core.ApplicationBuilder;
import com.speedment.runtime.core.Speedment;
import com.speedment.runtime.join.JoinComponent;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class AbstractDatabaseUnitTest {

    Speedment speedment;
    FilmManager films;
    ActorManager actors;
    FilmActorManager filmActors;
    JoinComponent joinComponent;

    @BeforeAll
    void setup() {
        speedment = new SakilaApplicationBuilder()
            .withPassword("sakila")
            .withParam("db.mysql.collationName", "utf8mb4_general_ci")
            .withParam("db.mysql.binaryCollationName", "utf8mb4_bin")
            .withLogging(ApplicationBuilder.LogType.STREAM)
            .build();
        films = speedment.getOrThrow(FilmManager.class);
        actors = speedment.getOrThrow(ActorManager.class);
        filmActors = speedment.getOrThrow(FilmActorManager.class);
        joinComponent = speedment.getOrThrow(JoinComponent.class);
    }

    @AfterAll
    void shutDown() {
        films = null;
        speedment.close();
    }


}