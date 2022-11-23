package com.example.movie_back.movie_back.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Table(name = "MOVIE")
@Getter
@Setter
@Entity
public class Movie {

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

/*   //해당일자 상영작의 매출총액 대비 해당 영화의 매출비율
    @Column(name = "salesShare")
    private String salesShare;

    //전일 대비 매출액 증감분
    @Column(name = "salesInten")
    private String salesInten;

    //전일 대비 매출액 증감 비율
    @Column(name = "salesChange")
    private String salesChange;

    //누적매출액
    @Column(name = "salesAcc")
    private String salesAcc;

    //해당일의 관객수
    @Column(name = "audiCnt")
    private String audiCnt;

    //전일 대비 관객수 증감분
    @Column(name = "audiInten")
    private String audiInten;

    //전일 대비 관객수 증감 비율
    @Column(name = "audiChange")
    private String audiChange;

    //누적관객수
    @Column(name = "audiAcc")
    private String audiAcc;

    //해당일자에 상영한 스크린수
    @Column(name = "scrnCnt")
    private String scrnCnt;

    //해당일자에 상영된 횟수
    @Column(name = "showCnt")
    private String showCnt;
*/
    public Movie(){}
    public Movie(Long id, String rnum, String boxofficeType, String rank,
                 String rankInten, String rankOldAndNew, String movieCd, String movieNm,
                 String openDt, String salesAmt){
        this.id=id;
        this.rnum = rnum;
        this.boxofficeType = boxofficeType;
        this.rank =rank;
        this.rankInten = rankInten;
        this.rankOldAndNew = rankOldAndNew;
        this.movieCd = movieCd;
        this.movieNm = movieNm;
        this.openDt = openDt;
        this.salesAmt = salesAmt;
    }
    /*//DB 저장 일자
    @Column(name = "targetDt")
    private String targetDt;

    @CreationTimestamp
    private LocalDateTime modification_date_time;*/
}
