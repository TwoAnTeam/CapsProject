import React, { Component } from 'react';
import BoardService from '../service/BoardService';

class CreateBoardComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            no: this.props.match.params.no,            
            type: '',
            title: '',
            contents: '',
            memberNo: '',
            createdTime: '',
            updatedTime: '',
            likes: '',
            counts: ''
        }

        this.changeTypeHandler = this.changeTypeHandler.bind(this);
        this.changeTitleHandler = this.changeTitleHandler.bind(this);
        this.changeContentsHandler = this.changeContentsHandler.bind(this);
        this.changeMemberNoHandler = this.changeMemberNoHandler.bind(this);
        this.state.counts = 0;
        this.state.updatedTime = '';
        this.state.createdTime = '';
        this.state.likes = 0;
        this.createBoard = this.createBoard.bind(this);
    }


    changeTypeHandler = (event) => {
        this.setState({type: event.target.value});
    }

    changeTitleHandler = (event) => {
        this.setState({title: event.target.value});
    }

    changeContentsHandler = (event) => {
        this.setState({contents: event.target.value});
    }

    changeMemberNoHandler = (event) => {
        this.setState({memberNo: event.target.value});
    }

    createBoard = (event) => {
        event.preventDefault();
        const date = new Date();
        let time = {
            year: date.getFullYear(), 
            month: date.getMonth() + 1, 
            date: date.getDate(), 
            hours: date.getHours(),
            minutes: date.getMinutes()
          };
        let created_time = `${time.year}/${time.month}/${time.date} ${time.hours}:${time.minutes}`;
        var up_time = `${time.year}/${time.month}/${time.date} ${time.hours}:${time.minutes}`;
        var likes_count = 0;
        var view_count = 0;

        let board = {
            type: this.state.type,
            title: this.state.title,
            contents: this.state.contents,
            memberNo: this.state.memberNo,
            createdTime: created_time,
            updatedTime: up_time,
            likes: likes_count,
            counts: view_count
        };
        console.log("board => "+ JSON.stringify(board));
        

       
        BoardService.createdBoard(board).then(res => {
            this.props.history.push('/board');
            window.location.replace('/board');
        });
        
    }

    cancel() {
        this.props.history.push('/board');
        window.location.replace('/board');
    }

    /*getTitle() {
        if (this.state.no === '_create') {
            return <h3 className="text-center">새글을 작성해주세요</h3>
        } else {
            return <h3 className="text-center">{this.state.no}글을 수정 합니다.</h3>
        }
    }*/

   /* componentDidMount() {
        if (this.state.no === '_create') {
            return
        } else {
            BoardService.getOneBoard(this.state.no).then( (res) => {
                let board = res.data;
                console.log("board => "+ JSON.stringify(board));
                const date = new Date();
                let time = {
                    year: date.getFullYear(), 
                    month: date.getMonth() + 1, 
                    date: date.getDate(), 
                    hours: date.getHours(),
                    minutes: date.getMinutes()
                };
                var up_time = `${time.year}/${time.month}/${time.date} ${time.hours}:${time.minutes}`;
                
                this.setState({
                        type: board.type,
                        title: board.title,
                        contents: board.contents,
                        memberNo: board.memberNo,
                        updatedTime: up_time,
                    });
            });
        }
    }*/


    render() {
        return (
            <div>
            <div className = "container">
                <div className = "row">
                    <div className = "card col-md-6 offset-md-3 offset-md-3">
                        <div className = "card-body">
                            <form>
                                <div className = "form-group">
                                    <label> Type </label>
                                    <select placeholder="type" name="type" className="form-control" 
                                    value={this.state.type} onChange={this.changeTypeHandler}>
                                        <option value="1">자유게시판</option>
                                        <option value="2">리뷰게시판</option>
                                    </select>
                                </div>
                                <div className = "form-group">
                                    <label> Title </label>
                                    <input type="text" placeholder="title" name="title" className="form-control" 
                                    value={this.state.title} onChange={this.changeTitleHandler}/>
                                </div>
                                <div className = "form-group">
                                    <label> Contents  </label>
                                    <textarea placeholder="contents" name="contents" className="form-control" 
                                    value={this.state.contents} onChange={this.changeContentsHandler}/>
                                </div>
                                <div className = "form-group">
                                    <label> MemberNo  </label>
                                    <input placeholder="memberNo" name="memberNo" className="form-control" 
                                    value={this.state.memberNo} onChange={this.changeMemberNoHandler}/>
                                </div>
                                <button className="btn btn-success" onClick={this.createBoard}>저장</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateBoardComponent;