package com.example.movie_back.GetMovie_Data.Controller;

import com.example.movie_back.GetMovie_Data.model.GetMovie;
import com.example.movie_back.GetMovie_Data.service.GetMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api")
public class GetMovieController {

    @Autowired
    private GetMovieService getMovieService;


    // get all board
    @GetMapping("/moviedata")
    public List<GetMovie> getAllMovie() {
        return getMovieService.getAllMovie();
    }


    @GetMapping("/moviedata/{no}")
    public ResponseEntity<GetMovie> getBoardByNo(
            @PathVariable Integer no) {

        return getMovieService.getMovie(no);
    }

}
