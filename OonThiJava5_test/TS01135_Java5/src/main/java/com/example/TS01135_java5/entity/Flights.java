package com.example.TS01135_java5.entity;

import jakarta.persistence.*;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat; // <-- THÊM IMPORT NÀY

@Entity
@Table(name = "Flights")
public class Flights {

    @Id
    private Integer flightID;

    @Column(name = "Airline", length = 100)
    private String airline;

    @Column(name = "DepartureCity", length = 100)
    private String departureCity;

    @Column(name = "ArrivalCity", length = 100)
    private String arrivalCity;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DepartureTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // <-- THÊM DÒNG NÀY
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ArrivalTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") // <-- THÊM DÒNG NÀY
    private Date arrivalTime;

    // Constructors và Getters/Setters giữ nguyên
    // ...
    public Flights() {
    }

    // (Getters and Setters)
    public Integer getFlightID() { return flightID; }
    public void setFlightID(Integer flightID) { this.flightID = flightID; }
    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }
    public String getDepartureCity() { return departureCity; }
    public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }
    public Date getDepartureTime() { return departureTime; }
    public void setDepartureTime(Date departureTime) { this.departureTime = departureTime; }
    public Date getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(Date arrivalTime) { this.arrivalTime = arrivalTime; }
}