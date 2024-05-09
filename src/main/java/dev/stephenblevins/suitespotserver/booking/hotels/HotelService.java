package dev.stephenblevins.suitespotserver.booking.hotels;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
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

        this.apiKey = dotenv.get("API_KEY");
        apiHost = dotenv.get("API_HOST");

        this.restTemplate = restTemplate;
    }

    public Optional<List<Hotel>> getHotels(
            String destId,
            String checkinDate,
            String checkoutDate,
            String roomNumber,
            String adultsNumber
    ) {

        String endpoint = "/v1/hotels/search";
        String apiUrl = "https://" + apiHost + endpoint;

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("dest_id", destId)
                .queryParam("checkin_date", checkinDate)
                .queryParam("checkout_date", checkoutDate)
                .queryParam("room_number", roomNumber)
                .queryParam("adults_number", adultsNumber);

        try {
            Hotel[] hotels = restTemplate.getForObject(builder.toUriString(), Hotel[].class);

            if (hotels != null && hotels.length > 0) {
                return Optional.of(Arrays.asList(hotels));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
