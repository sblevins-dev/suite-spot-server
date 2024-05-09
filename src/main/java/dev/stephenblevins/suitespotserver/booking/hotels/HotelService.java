package dev.stephenblevins.suitespotserver.booking.hotels;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final Dotenv dotenv;

    private final String apiKey;
    private final String apiHost;
    private final RestTemplate restTemplate;

    public HotelService(RestTemplate restTemplate) {
        dotenv = Dotenv.configure().load();

        apiKey = dotenv.get("API_KEY");
        apiHost = dotenv.get("API_HOST");

        this.restTemplate = restTemplate;
    }

    public Optional<List<Hotel>> getHotels(String dest_id) {
        return Optional.ofNullable(restTemplate.getForObject(apiHost + "/hotels", List.class));
    }
}
