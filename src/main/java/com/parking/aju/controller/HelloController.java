package com.parking.aju.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe responsável por controlar e validar a mensagem de boas vindas.
 */
@RestController
@RequestMapping(value = "/")
public class HelloController {

    /**
     * Método responsável por controlar e enviar uma mensagem na view index.
     *
     * @return Retorna uma mensagem de Boas-vindas ao usuário.
     */
    @GetMapping(produces = "application/json")
    public String hello() {
        return "Hello my brothers and Sisters. Java developers!";
    }
}
