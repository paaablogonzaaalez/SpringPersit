package com.adorno.examenPSYP.DTO;

import java.time.LocalDate;

public record SuscripcionDTO(
        String codigoReferencia,
        String nombreSocio,
        String nombreTarifa,
        LocalDate fechaInicio,
        Integer diasAsistencia,
        Double pagosAcumulados
) {}
