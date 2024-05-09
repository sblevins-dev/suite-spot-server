package dev.stephenblevins.suitespotserver.booking.locations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class LocationConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
