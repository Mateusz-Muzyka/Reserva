package app.reserve.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import app.reserve.api.model.Cart;
import app.reserve.api.model.CartDTORequest;
import app.reserve.api.model.Rooms;
import app.reserve.api.model.User;
import app.reserve.api.model.cartDTO;
import app.reserve.service.RoomRepo;
import app.reserve.service.UserRepository;
import app.reserve.service.cartRepo;
import app.reserve.service.cartService;
import app.reserve.service.cartServicePost;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/cart")
public class cartController {
    private final cartService cart_service;
    private final cartServicePost cart_SP;
    private final RoomRepo roomRepository;
    private final UserRepository userRepository;
    private final cartRepo cartRepository;

    public cartController(
        cartService cart_Service,
        cartServicePost cart_SP,
        RoomRepo roomRepository,
        UserRepository userRepository,
        cartRepo cartRepository
    ){
        this.cart_service = cart_Service;
        this.cart_SP = cart_SP;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

   @GetMapping("/{userId}")
   public List<cartDTO> getAllCartsOfUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return cart_service.GetAllCartsOfUser(user);
}

    @PostMapping("/add")
    public cartDTO addToCart(@RequestBody CartDTORequest cartDto) {
        User user = userRepository.findById(cartDto.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));
        Rooms room = roomRepository.findById(cartDto.getRoomId())
            .orElseThrow(() -> new RuntimeException("Room not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setRoom(room);

        cartRepository.save(cart);

        return new cartDTO(
            cart.getId(),
            user.getId(),
            user.getName(),
            room.getRid(),
            room.getRname(),
            room.getLocation(),
            room.getPrice()
        );
    }
}
