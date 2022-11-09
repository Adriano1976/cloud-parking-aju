package com.parking.aju.controller;

import com.parking.aju.controller.dto.ParkingCreateDTO;
import com.parking.aju.controller.dto.ParkingDTO;
import com.parking.aju.controller.mapper.ParkingMapper;
import com.parking.aju.model.ParkingModel;
import com.parking.aju.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<ParkingModel> parkingModelList = parkingService.findAll();
        List<ParkingDTO> parkingDTOList = parkingMapper.toParkingDTOList(parkingModelList);
        return ResponseEntity.ok(parkingDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        ParkingModel parkingModel = parkingService.findById(id);
        ParkingDTO parkingDTO = parkingMapper.toParkingDTO(parkingModel);
        return ResponseEntity.ok(parkingDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create((parkingCreate));
        var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingCreateDTO) {
        ParkingModel parkingModel = parkingMapper.toParkingCreate(parkingCreateDTO);
        ParkingModel parking = parkingService.update(id, parkingModel);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parking));
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable String id) {
        ParkingModel parkingModel = parkingService.checkOut(id);
        return ResponseEntity.ok(parkingMapper.toParkingDTO(parkingModel));
    }
}
