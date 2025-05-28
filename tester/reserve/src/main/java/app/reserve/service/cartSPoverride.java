package app.reserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.reserve.api.model.Cart;
import app.reserve.api.model.CartDTORequest;
import app.reserve.api.model.Rooms;
import app.reserve.api.model.User;
import app.reserve.api.model.cartDTO;

@Service
public class cartSPoverride implements cartServicePost {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepo roomRepository;

    @Autowired
    private cartRepo cartRepository;

 @Override
public cartDTO addToCart(CartDTORequest dto) {
    User user = userRepository.findById(dto.getUserId())
        .orElseThrow(() -> new RuntimeException("User not found"));

    Rooms room = roomRepository.findById(dto.getRoomId())
        .orElseThrow(() -> new RuntimeException("Room not found"));

    Cart cart = new Cart();
    cart.setUser(user);
    cart.setRoom(room);

    Cart saved = cartRepository.save(cart);

    return new cartDTO(
        saved.getId(),
        user.getId(),
        user.getName(),
        room.getRid(),
        room.getRname(),
        room.getLocation(),
        room.getPrice()
    );
}

}
