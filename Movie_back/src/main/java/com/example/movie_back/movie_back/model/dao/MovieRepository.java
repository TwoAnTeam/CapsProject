package com.example.movie_back.movie_back.model.dao;

import com.example.movie_back.movie_back.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
