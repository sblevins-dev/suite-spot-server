package dev.stephenblevins.suitespotserver.booking.locations;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class LocationService {
//    private final Dotenv dotenv;

    private final String apiKey;
    private final String apiHost;
    private final RestTemplate restTemplate;

    public LocationService(RestTemplate restTemplate,
                           @Value("${API_KEY}") String apiKey,
                           @Value("${API_HOST}") String apiHost
    ) {
//        dotenv = Dotenv.configure().load();
//
//        apiKey = dotenv.get("API_KEY");
//        apiHost = dotenv.get("API_HOST");

        this.apiKey = apiKey;
        this.apiHost = apiHost;

        this.restTemplate = restTemplate;
    }

    public Optional<Location> getLocationInfo(String name) {
        String formattedName = name.trim().replace(" ", "");

        String endpoint = "/v1/hotels/locations";
        String apiUrl = "https://" + apiHost + endpoint;

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                    .queryParam("name", formattedName)
                    .queryParam("locale", "en-us");

            String url = builder.toUriString();

            HttpHeaders headers = new HttpHeaders();
            headers.set("x-rapidapi-key", apiKey);
            headers.set("x-rapidapi-host", apiHost);

            HttpEntity<?> entity = new HttpEntity<>(headers);
            ResponseEntity<Location[]> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    Location[].class
            );
            Stream<Location> city = Arrays.stream(response.getBody()).filter(loc ->
                    loc.getDest_type().equals("city"));

            Optional<Location> location = city.findFirst();

            if (response.getStatusCode().is2xxSuccessful()) {
                return location;
            } else {
                return null;
            }
        } catch (HttpServerErrorException e) {
            System.err.println("Request failed with status code: " + e.getStatusCode());
            System.err.println("Response Body: " + e.getResponseBodyAsString());
            throw e;
        }


    }
}
