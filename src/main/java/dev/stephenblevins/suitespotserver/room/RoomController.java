package dev.stephenblevins.suitespotserver.room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/api/v1/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}
