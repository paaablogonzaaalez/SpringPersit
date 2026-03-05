package com.adorno.examenPSYP.Mappers;

import com.adorno.examenPSYP.DTO.SuscripcionDTO;
import com.adorno.examenPSYP.entity.Suscripcion;

public class SuscripcionMapper {

    public static SuscripcionDTO toDTO(Suscripcion suscripcion) {
        String nombreTarifa = suscripcion.getTarifa() != null
                ? suscripcion.getTarifa().getNombre()
                : "Sin tarifa";

        return new SuscripcionDTO(
                suscripcion.getCodigoReferencia(),
                suscripcion.getNombreSocio(),
                nombreTarifa,
                suscripcion.getFechaInicio(),
                suscripcion.getDiasAsistencia(),
                suscripcion.getPagosAcumulados()
        );
    }
}
