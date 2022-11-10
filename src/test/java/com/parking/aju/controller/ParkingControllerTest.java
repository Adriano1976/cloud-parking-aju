package com.parking.aju.controller;

import com.parking.aju.controller.dto.ParkingCreateDTO;
import com.parking.aju.controller.dto.ParkingDTO;
import com.parking.aju.model.ParkingModel;
import com.parking.aju.service.ParkingCheckOut;
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
public class ParkingControllerTest extends ContainerDatabaseDriver {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    /**
     * Método responsável por testar e validar a entrada de dados de autenticação do usuário.
     */
    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .auth().basic("user", "Aju@123456")
                .when()
                .get("/parking")
                .then()
                .statusCode(HttpStatus.OK.value());
    }

    /**
     * Método responsável por testar e validar a entrada de dados da classe {@link ParkingCreateDTO}.
     */
    @Test
    void whenCreateThenCheckIsCreated() {
        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AMARELO");
        createDTO.setLicense("WRT-5555");
        createDTO.setModel("BRASILIA");
        createDTO.setState("SP");

        Assertions.assertNotNull(createDTO);
        Assertions.assertSame(createDTO, createDTO);
        Assertions.assertEquals("BRASILIA", createDTO.getModel());
        Assertions.assertFalse(createDTO.toString().contains("ParkingCreateDTO{"));
        Assertions.assertTrue(true);

        RestAssured.given()
                .when()
                .auth().basic("user", "Aju@123456")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));
    }

    /**
     * Método responsável por testar e validar a entrada de dados da classe {@link ParkingDTO}.
     * Ela também faz s autenticação do usuário. Então é testado e validado a cobrança
     * de valores pelo serviço conforme a quantidade de horas ocorridas.
     */
    @Test
    void whenCreateThenCheckIsParkingDTO() {
        var parkingDTO = new ParkingDTO();
        parkingDTO.setColor("AMARELO");
        parkingDTO.setLicense("WRT-5555");
        parkingDTO.setModel("BRASILIA");
        parkingDTO.setState("SP");
        parkingDTO.setEntryDate(LocalDateTime.of(2022, 10, 15, 10, 58));
        parkingDTO.setExitDate(LocalDateTime.of(2022, 10, 15, 11, 58));
        parkingDTO.setBill(5.00);

        Assertions.assertNotNull(parkingDTO);
        Assertions.assertSame(parkingDTO, parkingDTO);
        Assertions.assertEquals("BRASILIA", parkingDTO.getModel());
        Assertions.assertEquals(5.00, ParkingCheckOut.ONE_HOUR_VALUE);
        Assertions.assertEquals(5.00, parkingDTO.getBill());
        Assertions.assertFalse(parkingDTO.toString().contains("ParkingDTO{"));
        Assertions.assertTrue(true);

        RestAssured.given()
                .when()
                .auth().basic("user", "Aju@123456")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(parkingDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));
    }

    /**
     * Método responsável por testar e validar a entrada de dados da classe {@link ParkingModel}.
     * Ela também faz s autenticação do usuário. Então é testado e validado a cobrança
     * de valores pelo serviço conforme a quantidade de horas ocorridas.
     */
    @Test
    void whenCreateThenCheckIsParkingModel() {
        var parking = new ParkingModel();
        parking.setColor("AMARELO");
        parking.setLicense("WRT-5555");
        parking.setModel("BRASILIA");
        parking.setState("SP");
        parking.setEntryDate(LocalDateTime.of(2022, 10, 15, 10, 58));
        parking.setExitDate(LocalDateTime.of(2022, 10, 15, 15, 58));

        Assertions.assertNotNull(parking);
        Assertions.assertSame(parking, parking);
        Assertions.assertEquals("BRASILIA", parking.getModel());
        Assertions.assertEquals(15.00, ParkingCheckOut.getBill(parking));
        Assertions.assertNull(parking.getBill());
        Assertions.assertNotEquals(5.00, parking.getBill());
        Assertions.assertFalse(parking.toString().contains("Parking{"));
        Assertions.assertTrue(true);

        RestAssured.given()
                .when()
                .auth().basic("user", "Aju@123456")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(parking)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("WRT-5555"))
                .body("color", Matchers.equalTo("AMARELO"));
    }
}
