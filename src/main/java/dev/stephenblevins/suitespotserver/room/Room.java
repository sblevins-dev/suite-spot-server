package dev.stephenblevins.suitespotserver.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "Rooms")
public class Room {
    @Id
    private Integer id;

    @JsonProperty("type")
    private String roomType; // Use a different field name to avoid conflict with 'type'

    @JsonProperty("hotelName")
    private String hotelName;

    @JsonProperty("rating")
    private Float rating;

    @JsonProperty("ratingAmount")
    private Integer ratingAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("pricePerNight")
    private Integer pricePerNight;

    @JsonProperty("amenities")
    private List<String> amenities;

    @JsonProperty("photos")
    private List<String> photos;

    // Getters and setters
    // Constructors
}
