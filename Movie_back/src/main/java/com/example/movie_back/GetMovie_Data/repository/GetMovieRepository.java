package com.example.movie_back.GetMovie_Data.repository;

import com.example.movie_back.GetMovie_Data.model.GetMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetMovieRepository extends JpaRepository<GetMovie, Integer> {

}
