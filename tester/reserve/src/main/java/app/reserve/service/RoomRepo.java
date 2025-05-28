package app.reserve.service;


import app.reserve.api.model.Rooms;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<Rooms, Long> {
    Optional<Rooms> findByroomName(String roomName);
    Optional<Rooms> findByLocation(String location);
    List<Rooms> findByType(String type);
    
}
