package dev.stephenblevins.suitespotserver.booking.hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<List<Hotel>> search(
            @RequestParam("dest_id") String dest_id,
            @RequestParam("checkin_date") String checkin_date,
            @RequestParam("checkout_date") String checkout_date,
            @RequestParam("room_number") String room_number,
            @RequestParam("adults_number") String adults_number
    ) {
        return hotelService.getHotels(
                dest_id,
                checkin_date,
                checkout_date,
                room_number,
                adults_number);
    }
}
