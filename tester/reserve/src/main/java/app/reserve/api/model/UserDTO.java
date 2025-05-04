package app.reserve.api.model;

import java.time.LocalDate;

public record UserDTO(Long id, String name, String password, String email, LocalDate Date) {

}
