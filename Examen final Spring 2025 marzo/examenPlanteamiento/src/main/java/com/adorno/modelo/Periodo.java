package com.adorno.modelo;

import java.time.LocalDate;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Periodo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	@NotNull
	private LocalDate fechaInicio;
	@Embedded
	private FechaFin fechafin;
	private Long recaudacion = 0l;
	private Long premios = 0l;
	@NonNull
	@NotNull
	@ManyToOne
	private Programa programa;
	@ManyToOne
	@NotNull
	@NonNull
	private Maquina maquina;
	
	public void cerrarPeriodo(@NonNull LocalDate fechaFin, Long recaudacion2, Long premios2) throws IllegalArgumentException {
		fechafin = new FechaFin(fechaInicio,fechaFin);
		recaudacion = recaudacion2;
		premios = premios2;
		
	}
}
