package app.reserve.api.model;

import java.math.BigDecimal;

public record RoomsDTO(long room_id, String companyName, String roomName, String companyEmail, String companyPhone, String location, BigDecimal price, String type) {

}
