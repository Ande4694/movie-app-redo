package com.example.demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements Serializable, MovieRepo {

    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Movie> searched = new ArrayList<>();


    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

    @Override
    public List<Movie> search(String title) {
        for (int i = 0; i<movies.size();i++){
            if (movies.get(i).getTitle().contains(title)){
                searched.add(movies.get(i));
            }
        }
        return searched;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getSearched() {
        return searched;
    }

    public void setSearched(ArrayList<Movie> searched) {
        this.searched = searched;
    }
}
