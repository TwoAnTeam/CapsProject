package com.example.movie_back.board_back.controller;

import java.util.List;
import java.util.Map;


import com.example.movie_back.board_back.model.Board;
import com.example.movie_back.board_back.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api")
public class BoardController {

    @Autowired
    private BoardService boardService;


    // get all board
    @GetMapping("/board")
    public List<Board> getAllBoards() {

        return boardService.getAllBoard();
    }

    @PostMapping("/board")
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);
    }

    @GetMapping("/board/{no}")
    public ResponseEntity<Board> getBoardByNo(
            @PathVariable Integer no) {

        return boardService.getBoard(no);
    }

    @DeleteMapping("/board/{no}")
    public ResponseEntity<Map<String, Boolean>> deleteBoardByNo(
            @PathVariable Integer no) {

        return boardService.deleteBoard(no);
    }


	/*@PutMapping("/board/{no}")
	public ResponseEntity<Board> updateBoardByNo(
			@PathVariable Integer no, @RequestBody Board board){

		return boardService.updateBoard(no, board);
	}*/

}
