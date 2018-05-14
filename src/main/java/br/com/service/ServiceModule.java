package br.com.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceModule {

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    public SalesService salesService() {
        return new SalesService();
    }

    @Bean
    public SalesmanService salesmanService() {
        return new SalesmanService();
    }

}
