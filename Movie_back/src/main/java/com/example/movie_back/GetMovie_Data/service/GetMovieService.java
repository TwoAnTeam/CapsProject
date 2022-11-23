package com.example.movie_back.GetMovie_Data.service;

import com.example.movie_back.GetMovie_Data.model.GetMovie;
import com.example.movie_back.GetMovie_Data.repository.GetMovieRepository;
import org.hibernate.cfg.CannotForceNonNullableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetMovieService {

    @Autowired
    private GetMovieRepository getMovieRepository;

    // get boards data
    public List<GetMovie> getAllMovie() {
        return getMovieRepository.findAll();
    }

    public ResponseEntity<GetMovie> getMovie(Integer no) {
        GetMovie movie = getMovieRepository.findById(no)
                .orElseThrow(() -> new CannotForceNonNullableException("Not exist Board Data by no : [" + no + "]"));
        return ResponseEntity.ok(movie);
    }
}