package app.reserve.api.model;

public class CartDTORequest {
    private Long userId;
    private String userName;
    private Long roomId;
    private String roomName;

    public CartDTORequest(Long userId, String userName, Long roomId, String roomName) {
        this.userId = userId;
        this.userName = userName;
        this.roomId = roomId;
        this.roomName = roomName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Long getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }
}



