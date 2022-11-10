package com.parking.aju.service;

import com.parking.aju.model.ParkingModel;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Classe Responsável pelo serviço de receber os dados da data e hora de permanência do veículo no
 * estacionamento e calcular o valor a ser pago pelo cliente.
 */
public class ParkingCheckOut {

    public static final int ONE_HOUR = 60;
    public static final int TWENTY_FOUR_HOUR = 24 * ONE_HOUR;
    public static final double ONE_HOUR_VALUE = 5.00;
    public static final double ADDITIONAL_PER_HOUR_VALUE = 2.00;
    public static final double DAY_VALUE = 20.00;

    /**
     * Método responsável por receber os dados do dia e horário de entrada e saído do veículo.
     *
     * @param parking Recebe as datas e horas de entrada e saída do veículo.
     * @return Retorna o valor já calculado.
     */
    public static Double getBill(ParkingModel parking) {
        return getCalculatedBill(parking.getEntryDate(), parking.getExitDate());
    }

    /**
     * Método responsável por receber os dados de entrada e saída do cliente e calcular o valor do serviço.
     *
     * @param entryDate Recebe os dados da data e horário de entrada.
     * @param exitDate Recebe os dados da data e horário de saída.
     * @return Retorna o valor calculado.
     */
    private static Double getCalculatedBill(LocalDateTime entryDate, LocalDateTime exitDate) {

        long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
        double bill = 0.0;

        if(minutes <= ONE_HOUR) {
            return ONE_HOUR_VALUE;
        }

        if(minutes <= TWENTY_FOUR_HOUR) {
            bill = ONE_HOUR_VALUE;
            int hours = (int) (minutes / ONE_HOUR);

            for (int i = 0; i < hours; i++) {
                bill += ADDITIONAL_PER_HOUR_VALUE;
            }

            return bill;
        }

        int days = (int) (minutes / TWENTY_FOUR_HOUR);
        for (int i = 0; i < days; i++){
            bill += DAY_VALUE;
        }

        return bill;
    }
}
