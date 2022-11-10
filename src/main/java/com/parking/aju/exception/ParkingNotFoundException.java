package com.parking.aju.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe responsável em controlar os dados de entreda da exceção da superclasse e
 * enviar uma mensagem de exception para o usuário.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ParkingNotFoundException extends RuntimeException{

    /**
     * Método responsável em enviar uma mensagem de erro ao usuário.
     *
     * @param id Recebe o código de identificação solicitado pelo usuário.
     */
    public ParkingNotFoundException(String id) {
        super("Parking not found with Id: " + id);
    }
}
