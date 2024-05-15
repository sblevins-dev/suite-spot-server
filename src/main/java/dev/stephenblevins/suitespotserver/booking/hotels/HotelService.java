package dev.stephenblevins.suitespotserver.booking.hotels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
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

    public ResponseEntity<List<Hotel>> getHotels(@RequestBody
            String destId,
            String checkinDate,
            String checkoutDate,
            String roomNumber,
            String adultsNumber
    ) {

        String endpoint = "/v1/hotels/search";
        String apiUrl = "https://" + apiHost + endpoint;

        try {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("dest_id", destId)
                .queryParam("dest_type", "city")
                .queryParam("checkin_date", checkinDate)
                .queryParam("checkout_date", checkoutDate)
                .queryParam("room_number", roomNumber)
                .queryParam("adults_number", adultsNumber)
                .queryParam("order_by", "popularity")
                .queryParam("filter_by_currency", "USD")
                .queryParam("locale", "en-us")
                .queryParam("units", "imperial");

        String url = builder.toUriString();


        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", apiKey);
        headers.set("x-rapidapi-host", apiHost);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                String.class
        );

            if (response.getStatusCode().is2xxSuccessful()) {
                List<Hotel> hotels = extractDataFromJson(response.getBody());

                return ResponseEntity.ok(hotels);
            } else {
                return null;
            }
        } catch (HttpServerErrorException e) {
            System.err.println("Request failed with status code: " + e.getStatusCode());
            System.err.println("Response Body: " + e.getResponseBodyAsString());
            throw e;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Hotel> extractDataFromJson(String responseBody) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(responseBody);
        JsonNode resultData = root.path("result");

        String data = objectMapper.writeValueAsString(resultData);

        List<Hotel> hotels = createHotelList(resultData);

        return hotels;
    }

    private List<Hotel> createHotelList(JsonNode data) {
        List<Hotel> hotels = new ArrayList<>();

        for (JsonNode hotelNode : data) {
            Hotel hotel = new Hotel();
            hotel.setReview_score(hotelNode.path("review_score").floatValue());
            hotel.setReview_score_word(hotelNode.path("review_score_word").asText());
            hotel.setAccommodation_type_name(hotelNode.path("accommodation_type_name").asText());
            hotel.setZip(hotelNode.path("zip").asText());
            hotel.setAddress(hotelNode.path("address").asText());
            hotel.setCity(hotelNode.path("city").asText());
            hotel.setMain_photo_url(hotelNode.path("main_photo_url").asText());
            hotel.setUrl(hotelNode.path("url").asText());
            hotel.setHotel_name(hotelNode.path("hotel_name").asText());
            hotel.setUnity_configuration_label(hotelNode.path("unity_configuration_label").asText());
            hotel.setMin_total_price(hotelNode.path("min_total_price").floatValue());
            hotel.setMax_photo_url(hotelNode.path("max_photo_url").asText());

            hotels.add(hotel);
        }


        return hotels;
    }
}
