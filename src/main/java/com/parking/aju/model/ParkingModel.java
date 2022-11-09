package com.parking.aju.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

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

    public ParkingModel() {
    }

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
