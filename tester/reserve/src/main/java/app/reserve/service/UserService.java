package app.reserve.service;
import app.reserve.api.model.*;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUsersById(Long id);
    Optional<UserDTO> getUserByName(String name);
    UserDTO saveUser(UserDTO UserDTO);
    UserDTO updateUser(Long id, UserDTO UserDTO);
    void deleteUser(Long id);
    
}