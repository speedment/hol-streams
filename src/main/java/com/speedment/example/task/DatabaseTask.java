package com.speedment.example.task;

import com.speedment.runtime.core.Speedment;

public interface DatabaseTask {

    /**
     * Returns the number of films in the database
     * @return the number of films in the database
     */
    long countFilms(Speedment speedment);

}
