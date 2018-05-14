package br.com.dataanalytic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataAnalyticModule {
    @Bean
    DataAnalytic dataAnalytic() {
        return new DataAnalytic();
    }
}
