package app.reserve.service;

import java.util.List;

import app.reserve.api.model.User;
import app.reserve.api.model.cartDTO;

public interface cartService {
    List<cartDTO> GetAllCartsOfUser(User user); 
}
