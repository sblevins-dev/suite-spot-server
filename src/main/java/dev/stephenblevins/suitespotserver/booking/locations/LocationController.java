package dev.stephenblevins.suitespotserver.booking.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/hotels")
public class LocationController {

    @Autowired LocationService locationService;

    @GetMapping("/locations")
    public Optional<Location> getLocationInfo(@RequestParam("name") String name) {
        return locationService.getLocationInfo(name);
    }
}
