package com.example.NguyenThiQuynhNhu.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DatabaseConfig {

    @Bean
    public MongoClient mongoClient() {
        String uri = "mongodb+srv://ntqnhu0105:Kin%40010504@my-portfolio.zlmjhva.mongodb.net/?appName=my-portfolio";
        return MongoClients.create(uri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "portfolio_db");
    }
}