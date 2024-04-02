package com.example.fullstack.repositories;

import com.example.fullstack.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getMovies() {
        String query = "SELECT * FROM movie;";
        RowMapper rowMapper = new BeanPropertyRowMapper(Movie.class);
        return  jdbcTemplate.query(query, rowMapper);

    }
    public Movie getMovie( int id ) {
        String query = "SELECT * FROM movie WHERE id = ?;";
        RowMapper<Movie> rowMapper = new BeanPropertyRowMapper<>(Movie.class);
        return jdbcTemplate.queryForObject(query, rowMapper, id);
    }

    public void delete(int id) {
        String query = "DELETE FROM movie WHERE id = ?;";
        jdbcTemplate.update(query,id);
    }

    public void insert(String title, int releaseYear, String description, String tags) {
        String query = "INSERT INTO movie (title, releaseYear, description, tags) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(query, title, releaseYear, description, tags);
    }

    public void update(int id, String title, int releaseYear, String description, String tags) {
        String query = "UPDATE movie " +
                "SET title = ?," +
                " release_year = ?, " +
                "description = ?, " +
                "tags = ? WHERE id = ?;";

        jdbcTemplate.update(query, title, releaseYear, description, tags, id);
    }
}
