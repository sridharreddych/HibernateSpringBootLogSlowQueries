package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            bookstoreService.persistAuthor();
            bookstoreService.displayAuthor();
        };
    }
}
/*
 * 
 * Log Slow Queries Via DataSource-Proxy

Description: This application is a sample of logging only slow queries via DataSource-Proxy. A slow query is a query that has an execution time bigger than a specificed threshold in milliseconds.

Key points:

for Maven, add in pom.xml the DataSource-Proxy dependency
create an bean post processor to intercept the DataSource bean
wrap the DataSource bean via ProxyFactory and an implementation of MethodInterceptor
choose a threshold in milliseconds
define a listener and override afterQuery()
 * 
 */
