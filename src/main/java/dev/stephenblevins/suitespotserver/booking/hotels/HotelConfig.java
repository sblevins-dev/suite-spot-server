package dev.stephenblevins.suitespotserver.booking.hotels;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HotelConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
