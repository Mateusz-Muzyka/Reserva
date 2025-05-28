package app.reserve.api.controller;

import app.reserve.service.cartRepo;
import app.reserve.service.cartService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import app.reserve.api.model.User;
import app.reserve.api.model.cartDTO;

@Service
public class cartServiceOverride implements cartService{

    private final cartRepo cart_repo;

    public cartServiceOverride(cartRepo cart_repo){
        this.cart_repo = cart_repo;
    }

    @Override
    public List<cartDTO> GetAllCartsOfUser(User user){
        return cart_repo.findByUser(user).stream()
            .map(cart -> new cartDTO(
                cart.getId(),
                cart.getUser().getId(),
                cart.getUser().getName(),
                cart.getRoom().getRid(),
                cart.getRoom().getRname(),
                cart.getRoom().getLocation(),
                cart.getRoom().getPrice()
            ))
            .collect(Collectors.toList());
    }


}
