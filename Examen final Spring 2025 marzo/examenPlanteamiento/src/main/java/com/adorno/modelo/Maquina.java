package com.adorno.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Maquina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@NonNull
//	@Size(min = 10, max=10)
	private String codigoReferencia;
	@NotNull
	@NonNull
	// verificar si es correcto
	private LocalDate fechaCreacion;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Periodo> historico = new ArrayList<>();
	@NotNull
	@NonNull
	private TipoHardware tipoHardware;

	public Optional<Periodo> addPeriodo(Periodo periodo, Long recaudacion, Long premios) {
		Periodo periodo2 = null;
		if (!historico.isEmpty()) {
			periodo2 = historico.get(historico.size() - 1);
			periodo2.cerrarPeriodo(periodo.getFechaInicio(), recaudacion, premios);
		}
		historico.add(periodo);
		return Optional.ofNullable(periodo2);
	}
}
