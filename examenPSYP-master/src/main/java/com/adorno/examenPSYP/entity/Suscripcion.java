package com.adorno.examenPSYP.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigoReferencia;

    @Column(nullable = false)
    private String nombreSocio;

    @ManyToOne
    @JoinColumn(name = "tarifa_id")
    private Tarifa tarifa;

    private LocalDate fechaInicio;

    @Builder.Default
    private Integer diasAsistencia = 0;

    @Builder.Default
    private Double pagosAcumulados = 0.0;
}
