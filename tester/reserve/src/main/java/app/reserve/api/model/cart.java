package app.reserve.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shipping_cart")
public class cart {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id_of_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms room_id;

    public Rooms getId() { return room_id; }
    public void setId(Rooms room_id) { this.room_id = room_id; }

    public User getUID() { return id; }
    public void setUID(User id) { this.id = id; }

    public Long getRid() { return id_of_id; }
    public void setRid(Long id_of_id) { this.id_of_id = id_of_id; }

}
