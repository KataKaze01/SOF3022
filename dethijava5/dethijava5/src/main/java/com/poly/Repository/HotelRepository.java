package com.poly.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
