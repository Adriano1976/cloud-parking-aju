package com.parking.aju.controller;

import com.parking.aju.controller.dto.ParkingCreateDTO;
import com.parking.aju.controller.dto.ParkingDTO;
import com.parking.aju.controller.mapper.ParkingMapper;
import com.parking.aju.model.ParkingModel;
import com.parking.aju.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Classe responsável por controlar e validar a manipulação dos dados do veículo.
 */
@RestController
@RequestMapping(value = "/parking")
@Api(tags = "Parking Controller")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;

    /**
     * Contrutor responsável por injetar as dependências.
     *
     * @param parkingService Recebe os dados de serviço.
     * @param parkingMapper  Recebe os dados de uma Lista.
     */
    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    /**
     * Metodo responsavel por listar os produtos para mostrar na view.
     * A anotação {@code @GetMapping} informa que respondera para a
     * requisição HTTP do tipo GET deve cair nesse método. Com isso,
     * o Spring MVC sabe que a view deve ser renderizada para o cliente.
     *
     * @return Retorna uma lista de veículos cadastrado no sistema.
     */
    @GetMapping(produces = "application/json")
    @ApiOperation("Find all parkings")
    public ResponseEntity<List<ParkingDTO>> findAll() {
        List<ParkingModel> parkingModelList = parkingService.findAll();
        List<ParkingDTO> parkingDTOList = parkingMapper.toParkingDTOList(parkingModelList);
        return ResponseEntity.ok().body(parkingDTOList);
    }

    /**
     * Metodo responsavel por listar os dados de um veículo da base de dados.
     *
     * @param id Recebe o código de identificação do veículo desejado.
     * @return Retorna uma lista de informações com os dados de um veículo.
     * A anotação {@code @GetMapping} informa que respondera para a requisição
     * HTTP do tipo GET deve cair nesse método.
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id) {
        ParkingModel parkingModel = parkingService.findById(id);
        ParkingDTO parkingDTO = parkingMapper.toParkingDTO(parkingModel);
        return ResponseEntity.ok().body(parkingDTO);
    }

    /**
     * Metodo responsavel por Deletar o produto escolhido pelo ‘id’.
     *
     * @param id Recebe o código de identificação do veículo da base de dados que deseja remover.
     * @return Retorna um status de confirmação ou não da remossão do veículo da base de dados.
     * A anotação {@code @DeleteMapping} informa que respondera para a requisição HTTP do tipo
     * DELETE deve cair nesse método. Com isso, o Spring MVC sabe que a view deve ser renderizada
     * para o cliente.
     */
    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Metodo responsavel por salvar as informacoes do veículo na base de dados.
     *
     * @param dto Recebe as informações do veículo do cliente.
     * @return Retorna ao formulario inicial apo salvar os dados e validado corretamente.
     */
    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto) {
        var parkingCreate = parkingMapper.toParkingCreate(dto);
        var parking = parkingService.create((parkingCreate));
        var result = parkingMapper.toParkingDTO(parking);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }

    /**
     * Metodo responsavel por Alterar os dados de um veículo escolhido pelo ‘id’.
     *
     * @param id               Recebe o código de identificação do veículo desejado.
     * @param parkingCreateDTO Recebe os dados do veículo da base de dados.
     * @return Retorna um status de confirmação ou não da alteração dos dados do veículo.
     * A anotação {@code @PutMapping} informa que respondera para a requisição HTTP do tipo
     * ‘UPDATE’ deve cair nesse método. Com isso, o Spring MVC sabe que a view deve ser
     * renderizada para o cliente.
     */
    @PutMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ParkingDTO> update(@PathVariable String id, @RequestBody ParkingCreateDTO parkingCreateDTO) {
        ParkingModel parkingModel = parkingMapper.toParkingCreate(parkingCreateDTO);
        ParkingModel parking = parkingService.update(id, parkingModel);
        return ResponseEntity.ok().body(parkingMapper.toParkingDTO(parking));
    }

    /**
     * Método responsável por controlar e retornar o valor do serviço ao cliente.
     *
     * @param id Recebe os dados do veículo que deseja encontrar.
     * @return Retorna os dados do veículo já com o valor do serviço inserido.
     */
    @PostMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<ParkingDTO> checkOut(@PathVariable String id) {
        ParkingModel parkingModel = parkingService.checkOut(id);
        return ResponseEntity.ok().body(parkingMapper.toParkingDTO(parkingModel));
    }
}
