package com.example.movie_back.board_back.repository;

import java.util.List;

import com.example.movie_back.board_back.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Integer> {

}
