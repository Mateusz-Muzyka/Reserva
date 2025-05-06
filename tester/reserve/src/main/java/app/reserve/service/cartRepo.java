package app.reserve.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.reserve.api.model.User;
import app.reserve.api.model.cart;

@Repository
public interface cartRepo extends JpaRepository<cart,Long> {
    List<cart> findByUser(User id);
}
