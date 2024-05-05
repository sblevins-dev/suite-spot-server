package dev.stephenblevins.suitespotserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuiteSpotServerApplication {
	private final Logger log = LoggerFactory.getLogger(SuiteSpotServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SuiteSpotServerApplication.class, args);
	}

}
