package app.reserve.service;
import java.util.List;
import java.util.Optional;

import app.reserve.api.model.*;

public interface RoomService {
    List<RoomsDTO> getAllRooms();
    Optional<RoomsDTO> getRoomByName(String roomName);
    Optional<RoomsDTO> getRoomByLocation(String location);
    Optional<RoomsDTO> getRoomById(Long room_id);
    List<RoomsDTO> getRoomByType(String type);
}
