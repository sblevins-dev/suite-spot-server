package dev.stephenblevins.suitespotserver.booking.hotels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/search")
    public Optional<List<Hotel>> search(
            @RequestParam("dest_id") String dest_id,
            @RequestParam("checkin_date") String checkin_date,
            @RequestParam("checkout_date") String checkout_date,
            @RequestParam("room_number") String room_number,
            @RequestParam("adults_number") String adults_number
    ) {
        return hotelService.getHotels(dest_id);
    }
}
