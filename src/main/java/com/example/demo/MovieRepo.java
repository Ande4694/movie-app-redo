package com.example.demo;

import java.util.List;

public interface MovieRepo {

    List<Movie> findAll();
    void save(Movie movie);
    List<Movie> search (String title);

}
