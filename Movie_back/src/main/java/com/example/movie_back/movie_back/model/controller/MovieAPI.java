package com.example.movie_back.movie_back.model.controller;

import com.example.movie_back.board_back.model.Board;
import com.example.movie_back.movie_back.model.Movie;
import com.example.movie_back.movie_back.model.dao.MovieRepository;
import com.example.movie_back.movie_back.model.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController
public class MovieAPI {

    @Autowired
    private MovieRepository movieRepository;


    //발급키
    String key = "c03acc76c8fa7eff81475abbd6b799dc";


    public void dailyBoxOffice(){
        Object test = "";
        String dailyResponse = "";
        List<Movie> list = null;

        //전날 박스오피스 조회
        LocalDateTime time = LocalDateTime.of(2022,11,18,0,0,0);
        String targetDt =  time.format(DateTimeFormatter.ofPattern("yyyMMdd"));

        //ROW 개수
        String itemPerPage = "10";

        //다양성영화(Y)/상업영화(N)/전체(default)
        String multiMovieYn = "";

        //한국영화(K)/외국영화(F)/전체(default)
        String repNationCd = "";

        //상영지역별 코드/전체(default)
        String wideAreaCd = "";

        try {
            // KOBIS 오픈 API Rest Client를 통해 호출
            KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);

            // 일일 박스오피스 서비스 호출 (boolean isJson, String targetDt, String itemPerPage,String multiMovieYn, String repNationCd, String wideAreaCd)
            dailyResponse = service.getDailyBoxOffice(true, "20221118", itemPerPage, multiMovieYn, repNationCd, wideAreaCd);

            //JSON Parser 객체 생성
            JSONParser jsonParser = new JSONParser();

            //Parser로 문자열 데이터를 객체로 변환
            Object obj = jsonParser.parse(dailyResponse);

            //파싱한 obj를 JSONObject 객체로 변환
            JSONObject jsonObject = (JSONObject) obj;

            //차근차근 parsing하기
            JSONObject parse_boxOfficeResult = (JSONObject) jsonObject.get("boxOfficeResult");

            test = (JSONArray)parse_boxOfficeResult.get("dailyBoxOfficeList");
            JSONArray tmp= (JSONArray) test;
            JSONObject t = (JSONObject)tmp.get(0);
            test = (String)t.get("rnum");

            //박스오피스 종류
            String boxofficeType = (String) parse_boxOfficeResult.get("boxofficeType");

            //박스오피스 조회 일자
            String showRange = (String) parse_boxOfficeResult.get("showRange");

            ObjectMapper objectMapper = new ObjectMapper();
            JSONArray parse_dailyBoxOfficeList = (JSONArray) parse_boxOfficeResult.get("dailyBoxOfficeList");

            for(int i=0; i<parse_dailyBoxOfficeList.size(); i++) {
                JSONObject temp = (JSONObject) parse_dailyBoxOfficeList.get(i);
                //JSON object -> Java Object(Entity) 변환
                //objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                Movie dailyMovie = new Movie(1 + (long) i, (String) temp.get("rnum"), (String) temp.get("boxofficeType"),
                        (String) temp.get("rank"), (String) temp.get("rankInten"),
                        (String) temp.get("rankOldAndNew"), (String) temp.get("movieCd"),
                        (String) temp.get("movieNm"), (String) temp.get("openDt"), (String) temp.get("salesAmt"));
                //(String)temp.get("salesShare"),(String)temp.get(""))
                //DB저장
                movieRepository.save(dailyMovie);
                test = dailyMovie;
            }

        }catch(Exception e) {
            e.getMessage();
        }
    }
}