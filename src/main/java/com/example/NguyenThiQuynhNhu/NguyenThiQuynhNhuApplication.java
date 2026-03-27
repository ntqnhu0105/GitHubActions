package com.example.NguyenThiQuynhNhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NguyenThiQuynhNhuApplication {

	public static void main(String[] args) {
		System.setProperty("spring.data.mongodb.uri", "mongodb+srv://ntqnhu0105:Kin%40010504@my-portfolio.zlmjhva.mongodb.net/?appName=my-portfolio");
		SpringApplication.run(NguyenThiQuynhNhuApplication.class, args);
	}

}
