package com.adorno.examenPSYP.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "historico_suscripciones")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricoSuscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigoSuscripcion;

    @Column(nullable = false)
    private String nombreTarifa;

    private Integer diasAsistencia;

    private Double pagosRealizados;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
