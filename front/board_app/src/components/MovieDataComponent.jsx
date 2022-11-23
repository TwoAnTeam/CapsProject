import React, { Component } from 'react';
import BoardService from '../service/BoardService';
import { useState } from 'react';

class MovieDataComponent extends Component{
    constructor(props) {
        super(props);

        this.state = { 
            movieList:[]
        }
    }

    componentDidMount() {
        BoardService.getMovies().then((res) =>{
            this.setState({ movieList: res.data });
        });
    }


    render(){
        

        return (
            <div>
                <div>
                    <div className='movieData'>      
                        <div>안녕
                            <table>    
                                {/*
                                    new Array = movieList.map(function(i){
                                    
                                    <tr key = {movie.id}>
                                        <td> <img alt='이미지 준비중' width={'150'} height={'200'}></img> </td>
                                        <td> {movieList.movieNm} </td>
                                    </tr>
                                    });*/
                                }                 
                            </table>
                        </div >                    
                    </div>
                </div>
            </div>
        );
    }


}

export default MovieDataComponent;