    package com.poly.DAO;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.data.jpa.repository.Query;
    import java.util.List;
    import com.poly.entity.Hotel;

    public interface HotelDAO extends JpaRepository<Hotel, Integer> {
        @Query("SELECT h FROM Hotel h WHERE h.hotelName LIKE %?1% OR CAST(h.hotelID AS string) LIKE %?1%")
        List<Hotel> search(String keyword);
    }
