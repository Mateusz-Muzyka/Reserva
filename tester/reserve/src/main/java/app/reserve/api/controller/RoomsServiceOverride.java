package app.reserve.api.controller;

import org.springframework.stereotype.Service;

import app.reserve.api.model.RoomsDTO;
import app.reserve.api.model.Rooms;
import app.reserve.service.RoomRepo;
import app.reserve.service.RoomService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomsServiceOverride implements RoomService{

    private final RoomRepo roomRepo;

    public RoomsServiceOverride(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @Override
    public List<RoomsDTO> getAllRooms() {
        return roomRepo.findAll().stream()
                .map(room -> new RoomsDTO(room.getRid(), room.getCname(), room.getRname(), room.getCemail(), room.getPhone(), room.getLocation(), room.getPrice(), room.getType()))
                .collect(Collectors.toList());
    }
    @Override
    public Optional<RoomsDTO> getRoomByName(String roomName) {
        return roomRepo.findByroomName(roomName).map(room -> new RoomsDTO(room.getRid(), room.getCname(), room.getRname(), room.getCemail(), room.getPhone(), room.getLocation(), room.getPrice(), room.getType()));
    }
    @Override
    public Optional<RoomsDTO> getRoomByLocation(String location) {
        return roomRepo.findByLocation(location).map(room -> new RoomsDTO(room.getRid(), room.getCname(), room.getRname(), room.getCemail(), room.getPhone(), room.getLocation(), room.getPrice(), room.getType()));
    }
    @Override
    public Optional<RoomsDTO> getRoomById(Long room_id) {
        return roomRepo.findById(room_id).map(room -> new RoomsDTO(room.getRid(), room.getCname(), room.getRname(), room.getCemail(), room.getPhone(), room.getLocation(), room.getPrice(), room.getType()));
    }
    @Override
    public List<RoomsDTO> getRoomByType(String type) {
        System.out.println("Searching for rooms with type: " + type);
        return roomRepo.findByType(type).stream()
                .map(room -> new RoomsDTO(room.getRid(), room.getCname(), room.getRname(), room.getCemail(), room.getPhone(), room.getLocation(), room.getPrice(), room.getType()))
                .collect(Collectors.toList());
    }
}
