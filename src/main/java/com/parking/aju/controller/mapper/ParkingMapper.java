package com.parking.aju.controller.mapper;

import com.parking.aju.controller.dto.ParkingCreateDTO;
import com.parking.aju.controller.dto.ParkingDTO;
import com.parking.aju.model.ParkingModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toParkingDTO(ParkingModel parkingModel) {
        return MODEL_MAPPER.map(parkingModel, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<ParkingModel> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public ParkingModel toParkingModel(ParkingDTO dto) {
        return MODEL_MAPPER.map(dto, ParkingModel.class);
    }

    public ParkingModel toParkingCreate(ParkingCreateDTO dto) {
        return MODEL_MAPPER.map(dto, ParkingModel.class);
    }
}
