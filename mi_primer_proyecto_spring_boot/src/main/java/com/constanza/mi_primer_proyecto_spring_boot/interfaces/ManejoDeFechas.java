package com.constanza.mi_primer_proyecto_spring_boot.interfaces;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface ManejoDeFechas {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    final DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    default LocalDate formatearFecha(String fecha) {
        LocalDate date = LocalDate.parse(fecha, formatter);
        return date;
    }
}