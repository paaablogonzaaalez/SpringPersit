package com.adorno.modelo;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class FechaFin {

    private LocalDate fecha;

    protected FechaFin() {}

    public FechaFin(LocalDate fecha, LocalDate fechaInicio) throws IllegalArgumentException {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha fin no puede ser nula.");
        }
        if (fechaInicio != null && fecha.isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha fin debe ser posterior a la fecha inicio.");
        }
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FechaFin that = (FechaFin) o;
        return Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha);
    }

    @Override
    public String toString() {
        return "FechaFin{" +
                "fecha=" + fecha +
                '}';
    }
}
