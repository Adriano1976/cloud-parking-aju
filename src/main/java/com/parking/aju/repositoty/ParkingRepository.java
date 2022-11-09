package com.parking.aju.repositoty;

import com.parking.aju.model.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingModel, String> {
}
