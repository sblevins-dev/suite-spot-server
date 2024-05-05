package dev.stephenblevins.suitespotserver.room;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class RoomDataLoader {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomDataLoader(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @PostConstruct
    public void loadRooms() throws IOException {
       try {
           ObjectMapper mapper = new ObjectMapper();
           TypeReference<List<Room>> typeReference = new TypeReference<>() {};
           InputStream inputStream = getClass().getResourceAsStream("/data/data.json");

           List<Room> rooms = mapper.readValue(inputStream, typeReference);
           roomRepository.saveAll(rooms);

           System.out.println("Loaded " + rooms.size() + " rooms");
       } catch (IOException e) {
           System.err.println("Failed to load rooms from JSON file: " + e.getMessage());
           e.printStackTrace();
       }

    }
}
