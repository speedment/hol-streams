package com.speedment.example.unit;

import com.speedment.runtime.core.Speedment;

public interface DatabaseUnit {

    /**
     * Returns the number of films in the database
     * @return the number of films in the database
     */
    long countFilms(Speedment speedment);

}
