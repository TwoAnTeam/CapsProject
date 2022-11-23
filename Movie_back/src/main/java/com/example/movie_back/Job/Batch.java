package com.example.movie_back.Job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/*import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;*/
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class Batch {
   /* private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final MovieService boxOfficeApiService;

    @Bean
    public Job testJob() {
        return jobBuilderFactory.get("testJob")
                .start(testStep(null))
                .build();
    }

    @Bean
    @JobScope
    public Step testStep(@Value("#{jobParameters[testParameter]}") String testParameter ) {
        testParameter = "20221118";
        return stepBuilderFactory.get("testStep")
                .tasklet((contribution, chunkContext) -> {
                    boxOfficeApiService.insertDailyBoxOffice();
                    return RepeatStatus.FINISHED;
                })
                .build();
    }*/
}
