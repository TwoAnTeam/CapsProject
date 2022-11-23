import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class ListBoardComponent extends Component {
    constructor(props) {
        super(props)
    
        this.state = { 
            boards: [],
        }

        this.createBoard = this.createBoard.bind(this);
    }
    
    componentDidMount() {
        BoardService.getBoards().then((res) => {
            this.setState({ boards: res.data});
        });
        /*BoardService.getMovies().then((res) =>{
            this.setState({ movies: res.data });
        });*/
    }

    createBoard() {
        this.props.history.push('/create-board');
        window.location.replace('/create-board');
    }

    readBoard(no) {
        this.props.history.push(`/read-board/${no}`);
        window.location.replace(`/read-board/${no}`);
    }

    movieData(){
        this.props.history.push('/movieData');
        window.location.replace('/movieData');
    }
   
    render(){

    return (
            <div>
                <h2 className="text-center">Boards List</h2>
                <div className = "row">
                    <button className="btn btn-primary" onClick={this.createBoard}> 글작성</button>
                </div>
                <div className ="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>게시판번호</th>
                                <th>타이틀 </th>
                                <th>내용</th>
                                <th>작성자 </th>
                                <th>작성일 </th>
                                <th>갱신일 </th>
                                <th>좋아요수</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                
                                this.state.boards.map(
                                    board => 
                                    <tr key = {board.no}>
                                        <td> {board.no} </td>
                                        <td> <a onClick = {() => this.readBoard(board.no)}>{board.title} </a></td>
                                        <td> {board.contents} </td>
                                        <td> {board.memberNo} </td>
                                        <td> {board.createdTime} </td>
                                        <td> {board.updatedTime} </td>
                                        <td> {board.likes} </td>
                                        <td> {board.counts} </td>
                                    </tr>
                                )

                            }
                        </tbody>
                    </table>
                    <div> 
                        <a onClick={this.movieData}>Test</a>
                    </div>
                </div>
            </div>
        );
    }
}



/*function withNavigation(Component) {
    return props => <Component {...props} navigate={useNavigate()} />;
}

export default function (props) {
    const navigation = useNavigate();
    return <ListBoardComponent {...props} navigation={navigation} />;
}
*/
export default ListBoardComponent;