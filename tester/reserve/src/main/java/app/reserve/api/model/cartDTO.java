package app.reserve.api.model;

import java.math.BigDecimal;

public record cartDTO(
    Long cartId,
    Long userId,
    String userName,
    Long roomId,
    String roomName,
    String location,
    BigDecimal price
) {}