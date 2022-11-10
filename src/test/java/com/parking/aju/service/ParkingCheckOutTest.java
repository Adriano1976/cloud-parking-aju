package com.parking.aju.service;

import com.parking.aju.controller.dto.ParkingCreateDTO;
import com.parking.aju.controller.dto.ParkingDTO;
import com.parking.aju.model.ParkingModel;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.testcontainers.jdbc.ContainerDatabaseDriver;

import java.time.LocalDateTime;

/**
 * Classe responsável por configurar, controlar e validar os testes realizados pelos métodos
 * de cadas tipo de testes e validação da entrada de dados na entidade {@link ParkingCreateDTO},
 * {@link ParkingDTO} e {@link ParkingModel}.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ParkingCheckOutTest extends ContainerDatabaseDriver {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    /**
     * Método responsável por testar e validar a entrada de dados do veículo,
     * passando pela autenticação do usuário. Então é testado e validado a cobrança
     * de valores pelo serviço conforme a quantidade de horas ocorridas.
     */
    @Test
    void getBillHour() {
        var parkingModel = new ParkingModel();
        parkingModel.setColor("AMARELO");
        parkingModel.setLicense("WRT-5555");
        parkingModel.setModel("BRASILIA");
        parkingModel.setState("SP");
        parkingModel.setEntryDate(LocalDateTime.of(2022, 10, 15, 10, 58));
        parkingModel.setExitDate(LocalDateTime.of(2022, 10, 15, 15, 58));

        Assertions.assertEquals(5.00, ParkingCheckOut.ONE_HOUR_VALUE);
        Assertions.assertEquals(15.00, ParkingCheckOut.getBill(parkingModel));
        Assertions.assertNotEquals(6.00, ParkingCheckOut.ONE_HOUR_VALUE);
        Assertions.assertNotEquals(5.00, ParkingCheckOut.getBill(parkingModel));
        Assertions.assertTrue(true);

        RestAssured.given()
                .when()
                .auth().basic("user", "Aju@123456")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(parkingModel)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));

    }

    /**
     * Método responsável por testar e validar a entrada de dados do veículo,
     * passando pela autenticação do usuário. Então é testado e validado a cobrança
     * de valores pelo serviço conforme a quantidade de dias ocorridos.
     */
    @Test
    void getBillDay() {
        var parkingModel = new ParkingModel();
        parkingModel.setColor("AMARELO");
        parkingModel.setLicense("WRT-5555");
        parkingModel.setModel("BRASILIA");
        parkingModel.setState("SP");
        parkingModel.setEntryDate(LocalDateTime.of(2022, 10, 15, 10, 58));
        parkingModel.setExitDate(LocalDateTime.of(2022, 10, 20, 15, 58));

        Assertions.assertEquals(20.00, ParkingCheckOut.DAY_VALUE);
        Assertions.assertEquals(100.00, ParkingCheckOut.getBill(parkingModel));
        Assertions.assertNotEquals(21.00, ParkingCheckOut.DAY_VALUE);
        Assertions.assertNotEquals(105.00, ParkingCheckOut.getBill(parkingModel));
        Assertions.assertTrue(true);

        RestAssured.given()
                .when()
                .auth().basic("user", "Aju@123456")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(parkingModel)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));

    }
}
