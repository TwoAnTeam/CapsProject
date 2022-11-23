package com.example.movie_back;

//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.example.movie_back.board_back.repository"}) // com.my.jpa.repository 하위에 있는 jpaRepository를 상속한 repository scan
//@EntityScan(basePackages = {"com.example.movie_back.model"}) // com.my.jpa.entity 하위에 있는 @Entity 클래스 scan
public class MovieBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieBackApplication.class, args);
    }

}
