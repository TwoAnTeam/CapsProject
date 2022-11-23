import axios from 'axios';


const BOARD_API_BASE_URL = "http://localhost:8080/api/board"; 

class BoardService {

    getBoards() {
        return axios.get(BOARD_API_BASE_URL);
    }

    getMovies(){
        return axios.get(BOARD_API_BASE_URL + "/moviedata");
    }

    createdBoard(board){
        return axios.post(BOARD_API_BASE_URL, board);
    }

    getOneBoard(no) {
        return axios.get(BOARD_API_BASE_URL + "/" + no);
    }

    updateBoard(no, board) {
        return axios.put(BOARD_API_BASE_URL + "/" + no, board);
    }

    deleteBoard(no) {
        return axios.delete(BOARD_API_BASE_URL + "/" + no);
    }

    getMovieData(id) {
        return axios.get(BOARD_API_BASE_URL + "/" + id);
    }
}

export default new BoardService();