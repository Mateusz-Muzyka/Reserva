package app.reserve.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import app.reserve.api.model.cartDTO;
import app.reserve.service.cartService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/cart")
public class cartController {
    private final cartService cart_service;
    public cartController(cartService cart_Service){
        this.cart_service = cart_Service;
    }
    
    @GetMapping("/{user}")
    public ResponseEntity<List<cartDTO>> GetAllCartsOfUser(@PathVariable long user_id){
        List<cartDTO> cart = cart_service.GetAllCartsOfUser(user_id);
        if(cart.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{

            return ResponseEntity.ok(cart);
        }
    }
}
