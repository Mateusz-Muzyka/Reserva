package app.reserve.service;

import app.reserve.api.model.CartDTORequest;
import app.reserve.api.model.cartDTO;

public interface cartServicePost {
    cartDTO addToCart(CartDTORequest cartDTORequest);
}
