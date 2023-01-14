package com.example.lab5_jdbctemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Lab5JdbcTemplateApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(Lab5JdbcTemplateApplication.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(Lab5JdbcTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) {
		logger.info("StartApplication...");
		runJDBC();
	}

	void runJDBC() {
		this.jdbcTemplate.execute("CREATE TABLE users(" +
				"id SERIAL, " +
				"email VARCHAR(255)," +
				"firstName VARCHAR(255)," +
				"secondName VARCHAR(255))");
	}

}
