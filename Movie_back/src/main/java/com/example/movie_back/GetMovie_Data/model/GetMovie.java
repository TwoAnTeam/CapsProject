package com.example.movie_back.GetMovie_Data.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "MOVIE")
@DynamicInsert
@DynamicUpdate
public class GetMovie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rnum")
    private String rnum;

    /*박스오피스 종류*/
    @Column(name = "boxofficeType")
    private String boxofficeType;

    /*박스오피스 조회 일자*/
    /*@Column(name = "showRange")
    private String showRange;*/

    /*해당일자의 박스오피스 순위*/
    @Column(name = "rank")
    private String rank;

    /*전일대비 순위의 증감분*/
    @Column(name = "rankInten")
    private String rankInten;

    /*랭킹에 신규진입여부 “OLD” : 기존 , “NEW” : 신규*/
    @Column(name = "rankOldAndNew")
    private String rankOldAndNew;

    /*영화의 대표코드*/
    @Column(name = "movieCd")
    private String movieCd;

    /*영화명(국문)*/
    @Column(name = "movieNm")
    private String movieNm;

    /*영화의 개봉일*/
    @Column(name = "openDt")
    private String openDt;

    /*해당일의 매출액*/
    @Column(name = "salesAmt")
    private String salesAmt;
}
