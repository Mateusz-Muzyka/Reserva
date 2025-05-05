package app.reserve.api.controller;

import app.reserve.api.model.*;
import app.reserve.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostController implements UserService {

    private final UserRepository userRepository;

    public PostController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> getUsersById(Long id) {
        return userRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public UserDTO saveUser(UserDTO UserDTO) {
        User product = convertToEntity(UserDTO);
        User savedProduct = userRepository.save(product);
        return convertToDTO(savedProduct);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO UserDTO) {
        User product = userRepository.findById(id).orElseThrow();
        product.setName(UserDTO.name());
        product.setPassword(UserDTO.password());
        User updatedProduct = userRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Convert Product Entity to UserDTO
    private UserDTO convertToDTO(User product) {
        return new UserDTO(product.getId(), product.getName(), product.getPassword(), product.getEmail(), product.getDate());
    }

    // Convert UserDTO to Product Entity
    private User convertToEntity(UserDTO UserDTO) {
        User product = new User();
        product.setName(UserDTO.name());
        product.setPassword(UserDTO.password());
        product.setEmail(UserDTO.email());
        product.setDate(UserDTO.Date());
        return product;
    }

    public boolean validateUser(String name, String password) {
        Optional<User> user = userRepository.findByName(name);
        return user.isPresent() && user.get().getPassword().equals(password);
    }

    public Optional<UserDTO> getUserByName(String name){
        return userRepository.findByName(name).map(this::convertToDTO);
    }
}
