package app.reserve.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.reserve.api.model.Cart;
import app.reserve.api.model.User;

@Repository
public interface cartRepo extends JpaRepository<Cart,Long> {
    List<Cart> findByUser(User user);
}
