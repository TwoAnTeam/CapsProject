package com.example.movie_back.movie_back.model.service;

import com.example.movie_back.movie_back.model.Movie;
import com.example.movie_back.movie_back.model.controller.MovieAPI;
import com.example.movie_back.movie_back.model.dao.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieAPI boxOfficeApi;

    @Autowired
    private MovieRepository repository;

    public void insertDailyBoxOffice(){
        boxOfficeApi.dailyBoxOffice();
    }
    public List<Movie> getAllData(){ return repository.findAll(); }
}