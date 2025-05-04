package app.reserve.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import app.reserve.service.*;
import app.reserve.api.model.*;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RoomService roomService;
    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping
    public List<RoomsDTO> getAllRooms() {
        return roomService.getAllRooms();
    }


    @GetMapping("/{type}")
    public ResponseEntity<List<RoomsDTO>> getRoomByType(@PathVariable String type) {
        System.out.println("Received type: " + type);
        List<RoomsDTO> rooms = roomService.getRoomByType(type);
        if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/spec/{id}")
    public ResponseEntity<Optional<RoomsDTO>> getRoomById(@PathVariable Long id){
        Optional<RoomsDTO> room = roomService.getRoomById(id);
        if(room.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(room);
        }

    }
}
