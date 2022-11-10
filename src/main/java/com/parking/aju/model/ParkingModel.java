package com.parking.aju.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/*
Pode forçar o Hibernate a citar um identificador no SQL gerado, anexando o nome da tabela
ou coluna em backticks no documento de mapeamento. Enquanto tradicionalmente, o Hibernate usava
backticks para escapar das palavras-chave reservadas do SQL, o JPA usa aspas duplas.

Depois que as palavras-chave reservadas forem escapadas, o Hibernate usará o estilo de cotação
correto para o SQL Dialect. Geralmente, são aspas duplas, mas o SQL Server usa colchetes e o
MySQL usa backticks.
**/

/**
 * Classe responsável por receber os dados do carro usuário e servir como
 * modelo da entidade na criação da tabela na base de dados.
 */
@Entity
@Table(name = "tab_parking")
public class ParkingModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_parking", length = 100, nullable = false)
    private String id;
    @Column(name = "license", length = 10, nullable = false)
    private String license;
    @Column(name = "state", length = 2, nullable = false)
    private String state;
    @Column(name = "model", length = 100, nullable = false)
    private String model;
    @Column(name = "color", length = 100, nullable = false)
    private String color;
    @Column(name = "entry_date", length = 100, nullable = false)
    private LocalDateTime entryDate;
    @Column(name = "exit_date", length = 100)
    private LocalDateTime exitDate;
    @Column(name = "bill", length = 10)
    private Double bill;

    /**
     * Construtor sem parâmetro.
     */
    public ParkingModel() {
    }

    /**
     * @param id Recebe o número do código de identificação.
     * @param license Recebe os dados da placa do corro do cliente.
     * @param state Recebe a sigla do estado do carro do cliente.
     * @param model Recebe o nome do modelo do carro do cliente.
     * @param color Recebe o nome da cor do carro do cliente.
     */
    public ParkingModel(String id, String license, String state, String model, String color) {
        this.id = id;
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDateTime getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDateTime entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Double getBill() {
        return bill;
    }

    public void setBill(Double bill) {
        this.bill = bill;
    }

}
