package com.poly.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Hotels")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HotelID")
    private Integer hotelID;

    @Column(name = "HotelName")
    private String hotelName;

    @Column(name = "Location")
    private String location;

    @Column(name = "Rating")
    private Double rating;

    @Column(name = "RoomsAvailable")
    private Integer roomsAvailable;

    @Column(name = "ContactEmail")
    private String contactEmail;
}
