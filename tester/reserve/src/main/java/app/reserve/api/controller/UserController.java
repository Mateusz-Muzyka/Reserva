package app.reserve.api.controller;

import app.reserve.api.model.*;
import app.reserve.service.UserRepository;
import app.reserve.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;
    private final PostController postController;
    public UserController(UserService userService, PostController postController) {
        this.userService = userService;
        this.postController = postController;
    }
    

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        Optional<UserDTO> user = userService.getUsersById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        try {
            UserDTO updatedUser = userService.updateUser(id, userDTO);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String name = loginData.get("name");
        String password = loginData.get("password");
    
        System.out.println("Otrzymane dane: name=" + name + ", password=" + password);
    
        if (postController.validateUser(name, password)) {
            System.out.println("Logowanie udane dla użytkownika: " + name); 
            return ResponseEntity.ok("Logowanie powiodlo sie");
        } else {
            System.out.println("Niepoprawne dane logowania dla użytkownika: " + name); 
            return ResponseEntity.status(401).body("Logowanie niepowiodlo sie");
        }
    }

    @GetMapping("/finder/{name}")
    public ResponseEntity<Optional<UserDTO>> findByName(@PathVariable String name){
        Optional<UserDTO> user = userService.getUserByName(name);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(user);
        }

    }

}
