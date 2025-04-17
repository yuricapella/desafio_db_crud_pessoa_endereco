package br.com.db.desafio_crud_pessoa_endereco.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class FormataData {
    public static final String PADRAO_DATA_HORA = "dd/MM/yyyy:HH:mm:ss";
    public static final String PADRAO_DATA = "dd/MM/yyyy";

    public static String formatarData(LocalDate data) {
        return data.format(DateTimeFormatter.ofPattern(PADRAO_DATA));
    }

    public static String formatarDataHora(LocalDateTime dataHora) {
        return dataHora.format(DateTimeFormatter.ofPattern(PADRAO_DATA_HORA));
    }

    public static int calcularIdade(LocalDate data) {
        return Period.between(data, LocalDate.now()).getYears();
    }
}
