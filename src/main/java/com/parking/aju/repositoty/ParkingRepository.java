package com.parking.aju.repositoty;

import com.parking.aju.model.ParkingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ‘Interface’ responsável em informar a classe controladora de como deve ser manipulado os dados
 * conforme a extenção {@link JpaRepository}.
 */
@Repository
public interface ParkingRepository extends JpaRepository<ParkingModel, String> {
}
