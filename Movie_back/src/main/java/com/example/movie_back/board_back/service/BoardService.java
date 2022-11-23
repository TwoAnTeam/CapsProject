package com.example.movie_back.board_back.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.movie_back.board_back.model.Board;

import com.example.movie_back.board_back.repository.BoardRepository;
import org.hibernate.cfg.CannotForceNonNullableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // get boards data
    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    public ResponseEntity<Board> getBoard(Integer no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new CannotForceNonNullableException("Not exist Board Data by no : ["+no+"]"));
        return ResponseEntity.ok(board);
    }

    public ResponseEntity<Map<String, Boolean>> deleteBoard(
            Integer no) {
        Board board = boardRepository.findById(no)
                .orElseThrow(() -> new CannotForceNonNullableException("Not exist Board Data by no : ["+no+"]"));

        boardRepository.delete(board);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted Board Data by id : ["+no+"]", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

	/*public ResponseEntity<Board> updateBoard(
			Integer no, Board updatedBoard) {
		Board board = boardRepository.findById(no)
				.orElseThrow(() -> new ResourceNotFoundException("Not exist Board Data by no : ["+no+"]"));
		board.setType(updatedBoard.getType());
		board.setTitle(updatedBoard.getTitle());
		board.setContents(updatedBoard.getContents());
		board.setUpdatedTime(new Date().toString());
		board.setCounts(updatedBoard.getCounts());

		Board endUpdatedBoard = boardRepository.save(board);
		return ResponseEntity.ok(endUpdatedBoard);
	}*/
}