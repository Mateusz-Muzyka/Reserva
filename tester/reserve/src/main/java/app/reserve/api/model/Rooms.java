package app.reserve.api.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Rooms {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long room_id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "room_name")
    private String roomName;
    @Column(name = "company_email")
    private String companyEmail;
    @Column(name = "company_phone")
    private String companyPhone;
    @Column(name = "location")
    private String location;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "type")
    private String type;
    
    public Long getRid() { return room_id; }
    public void setRid(Long room_id) { this.room_id = room_id; }
    
    public String getCname() { return companyName; }
    public void setCname(String companyName) { this.companyName = companyName; }
    
    public String getRname() { return roomName; }
    public void setname(String roomName) { this.roomName = roomName; }

    public String getCemail() { return companyEmail; }
    public void setCemail(String companyEmail) { this.companyEmail = companyEmail; }

    public String getPhone() { return companyPhone; }
    public void setPhone(String companyPhone) { this.companyPhone = companyPhone; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getType() {return type;}
    public void settype(String type) {this.type = type;}
}
