package com.example.fullstack.services;

import com.example.fullstack.model.Movie;
import com.example.fullstack.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public List<Movie> getMovies() {
        return  movieRepository.getMovies();
    }
    public Movie getMovie( int id) {
        return movieRepository.getMovie(id);
    }

    public void delete(int id) {
        movieRepository.delete(id);
    }

    public void insert(String title, int releaseYear, String description, String tags) {
        movieRepository.insert(title, releaseYear, description, tags);
    }

    public Movie prepareUpdate(int id) {
        return movieRepository.getMovie(id);
    }

    public void update(int id, String title, int releaseYear, String description, String tags) {
        movieRepository.update(id, title, releaseYear, description, tags);
    }
}
