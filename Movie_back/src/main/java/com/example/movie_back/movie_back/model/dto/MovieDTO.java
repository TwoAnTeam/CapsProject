package com.example.movie_back.movie_back.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public class MovieDTO {
    private Long id;
    private String rnum;
    private String boxofficeType;

    /*박스오피스 조회 일자*/
    /*@Column(name = "showRange")
    private String showRange;*/
    private String rank;
    private String rankInten;
    private String rankOldAndNew;
    private String movieCd;
    private String movieNm;
    private String openDt;
    private String salesAmt;
}
