package com.adorno.examenPSYP.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.adorno.examenPSYP.entity.Suscripcion;
import com.adorno.examenPSYP.entity.Tarifa;

@DataJpaTest
class SuscripcionRepositoryTest {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Autowired
    private TarifaRepository tarifaRepository;

    @Test
    void testFindByCodigoReferencia() {
        // Given: Necesitamos una tarifa primero para la relación
        Tarifa tarifa = tarifaRepository.save(Tarifa.builder().nombre("Test").precio(10.0).build());
        
        Suscripcion sub = Suscripcion.builder()
                .codigoReferencia("REF-123")
                .nombreSocio("Carlos")
                .tarifa(tarifa)
                .fechaInicio(LocalDate.now())
                .build();
        suscripcionRepository.save(sub);

        // When
        Optional<Suscripcion> resultado = suscripcionRepository.findByCodigoReferencia("REF-123");

        // Then
        assertTrue(resultado.isPresent());
        assertEquals("Carlos", resultado.get().getNombreSocio());
        assertEquals("Test", resultado.get().getTarifa().getNombre());
    }
}