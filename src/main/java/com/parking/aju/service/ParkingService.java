package com.parking.aju.service;

import com.parking.aju.exception.ParkingNotFoundException;
import com.parking.aju.model.ParkingModel;
import com.parking.aju.repositoty.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Classe responsável por controlar e intermediar a manipulação dos dados entre a base de dados
 * e a classe responsável em controlar - {@link ParkingRepository} — dos dados do carro do cliente.
 */
@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    /**
     * Construtor responsável em injetar a dependência {@link ParkingRepository}.
     *
     * @param parkingRepository Recebe os dados do carro do cliente.
     */
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    /**
     * Método responsável em representa um identificador exclusivo universal imutável (UUID), que representa um valor de 128 bits.
     *
     * @return Retorna um identificador aleatório e formatado.
     */
    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Médoto responsável pelo serviço de recuperar e listar todos os dados do carro do cliente.
     *
     * @return Retorna os dados do carro do cliente.
     */
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<ParkingModel> findAll() {
        return parkingRepository.findAll();
    }

    /**
     * Método responsável pelo serviço de solicitar os dados do carro do cliente.
     *
     * @param id Recebe o código de identificação dos dados do carro do cliente solicitado.
     * @return Retorna com os dados de um determinado carro conforme o código encontrado na base de dados..
     */
    @Transactional(readOnly = true)
    public ParkingModel findById(String id) {
        return parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    /**
     * Método responsável pelo serviço de receber os novos dados do carro do cliente e solicitar
     * o envio do mesmo para a base de dados.
     *
     * @param parkingCreate Recebe os dados do carro do cliente.
     * @return Retorna o status de verdadeiro quando os dados são inseridos com sucesso.
     */
    @Transactional
    public ParkingModel create(ParkingModel parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    /**
     * Método responsável por controlar e deletar os dados de um determinado carro da base dados.
     *
     * @param id Recebe o código dos dados do carro do cliente que deseja apagar da base de dados.
     */
    @Transactional
    public void delete(String id) {
        try {
            findById(id);
            parkingRepository.deleteById(id);
        } catch (ParkingNotFoundException exception) {
            throw new ParkingNotFoundException(id);
        }
    }

    /**
     * Médoto responsável pelo serviço de solicitar a alteração os dados de um determinado veículo.
     *
     * @param id Recebe o código do produto que deseja alterar.
     * @param parkingCreate Recebe os dados do veículo que deseja alterar.
     * @return Retorna o status de verdadeiro quando os dados são inseridos com sucesso.
     */
    @Transactional
    public ParkingModel update(String id, ParkingModel parkingCreate) {
        try {
            ParkingModel parking = findById(id);
            parking.setColor(parkingCreate.getColor());
            parking.setState(parkingCreate.getState());
            parking.setModel(parkingCreate.getModel());
            parking.setLicense(parkingCreate.getLicense());
            parkingRepository.save(parking);
            return parking;
        } catch (ParkingNotFoundException exception) {
            throw new ParkingNotFoundException(id);
        }
    }

    /**
     * Método responsável pelo serviço de solicitar os dados do veículo com o valor do serviço.
     *
     * @param id Recebe o código de identificação do veículo.
     * @return Retorna com os dados do veículo com o valor da hora calculado.
     */
    @Transactional
    public ParkingModel checkOut(String id) {
        try {
            ParkingModel parking = findById(id);
            parking.setExitDate(LocalDateTime.now());
            parking.setBill(ParkingCheckOut.getBill(parking));
            parkingRepository.save(parking);
            return parking;
        } catch (ParkingNotFoundException exception) {
            throw new ParkingNotFoundException(id);
        }
    }
}
